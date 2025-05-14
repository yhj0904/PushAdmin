package com.nanwe.push.service.impl;

import com.nanwe.push.dto.PushSendRequestDto;
import com.nanwe.push.entity.*;
import com.nanwe.push.repository.*;
import com.nanwe.push.service.FcmService;
import com.nanwe.push.service.PushSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PushSendServiceImpl implements PushSendService {

    private final PushAppRepository pushAppRepository;
    private final PushSendRepository pushSendRepository;
    private final PushSendUserRepository pushSendUserRepository;
    private final PushSendListRepository pushSendListRepository;
    private final PushWebSendListRepository pushWebSendListRepository;
    private final PushSendStackRepository pushSendStackRepository;
    private final FcmService fcmService;
    private final PushAppUserTokenRepository pushAppUserTokenRepository;


    /**
     * 푸시 발송 전체 처리
     */
    @Override
    public void sendPush(PushSendRequestDto request) {
        PushApp app = getAppSetting(request);                    // 1. 앱 설정 조회
        PushSend pushSend = registerPushMaster(request);         // 2. 발송 마스터 등록
        registerRecipients(request, pushSend);                   // 3. 발송 대상자 등록
        createChannelLists(request, pushSend, app);              // 4. 채널별 발송 리스트 생성
        updateSendCounts(request, pushSend, app);                // 5. 발송 건수 및 상태 업데이트
        saveSendLog(request, pushSend);                          // 6. 처리 로그 저장
        // 실제 푸시 발송
        sendFcmToTargets(request, pushSend);

    }

    /**
     * Step 1 - APP 설정 조회 (푸시/SMS/웹 푸시 사용 여부 확인)
     */
    private PushApp getAppSetting(PushSendRequestDto request) {
        PushApp app = pushAppRepository.findById(request.getAppId())
                .orElseThrow(() -> new IllegalArgumentException("해당 앱이 존재하지 않습니다: " + request.getAppId()));
        log.info("앱 설정 조회 완료 - PUSH: {}, SMS: {}, WEB: {}",
                app.getPushUseAt(), app.getSmsUseAt(), app.getWebUseAt());
        return app;
    }

    /**
     * Step 2 - 푸시 발송 마스터 등록
     */
    private PushSend registerPushMaster(PushSendRequestDto request) {
        PushSend pushSend = PushSend.builder()
                .appId(request.getAppId())
                .noticeTitle(request.getNoticeTitle())
                .noticeBody(request.getNoticeBody())
                .noticeImg(request.getNoticeImg())
                .noticeUrl(request.getNoticeUrl())
                .noticeAction(request.getNoticeAction())
                .userId(request.getUserId())
                .userNm(request.getUserNm())
                .userMobile(request.getUserMobile())
                .noticeDt(request.getReservationDt() != null ? request.getReservationDt() : LocalDateTime.now())
                .pushUse(request.getPushUse())
                .smsUse(request.getSmsUse())
                .webUse(request.getWebUse())
                .pushCnt(0)
                .pushSuccessCnt(0)
                .pushFailCnt(0)
                .smsCnt(0)
                .smsSuccessCnt(0)
                .smsFailCnt(0)
                .totalCnt(0)
                .pushState("WAIT")
                .userNmAt(request.getUserNmAt())
                .build();

        pushSend = pushSendRepository.save(pushSend);
        log.info("발송 마스터 저장 완료. NOTICE_NO = {}", pushSend.getNoticeNo());
        return pushSend;
    }

    /**
     * Step 3 - 발송 대상자 등록 (T_PUSH_SEND_USER)
     */
    private void registerRecipients(PushSendRequestDto request, PushSend pushSend) {
        List<PushSendUser> sendUsers = Arrays.stream(request.getSendUserList().split(","))
                .filter(u -> u != null && !u.trim().isEmpty())
                .map(userId -> PushSendUser.builder()
                        .appId(request.getAppId())
                        .noticeNo(pushSend.getNoticeNo())
                        .userId(userId.trim())
                        .successYn("N")
                        .failMsg(null)
                        .build())
                .collect(Collectors.toList());

        pushSendUserRepository.saveAll(sendUsers);
        log.info("발송 대상자 {}명 저장 완료", sendUsers.size());
    }

    /**
     * Step 4 - 푸시 / 웹 푸시 발송 리스트 생성
     */
    private void createChannelLists(PushSendRequestDto request, PushSend pushSend, PushApp app) {
        List<PushSendUser> users = pushSendUserRepository.findByAppIdAndNoticeNo(request.getAppId(), pushSend.getNoticeNo());

        if ("Y".equalsIgnoreCase(app.getPushUseAt())) {
            List<PushSendList> pushList = users.stream().map(u ->
                    PushSendList.builder()
                            .appId(u.getAppId())
                            .noticeNo(u.getNoticeNo())
                            .userId(u.getUserId())
                            .userNm(null)
                            .successYn("N")
                            .failMsg(null)
                            .sendDt(null)
                            .build()
            ).collect(Collectors.toList());
            pushSendListRepository.saveAll(pushList);
            log.info("PUSH 발송 대상자 {}명 저장 완료", pushList.size());
        }

        if ("Y".equalsIgnoreCase(app.getWebUseAt())) {
            List<PushWebSendList> webList = users.stream().map(u ->
                    PushWebSendList.builder()
                            .appId(u.getAppId())
                            .noticeNo(u.getNoticeNo())
                            .userId(u.getUserId())
                            .webToken(null)
                            .successYn("N")
                            .failMsg(null)
                            .sendDt(null)
                            .build()
            ).collect(Collectors.toList());
            pushWebSendListRepository.saveAll(webList);
            log.info("WEB PUSH 발송 대상자 {}명 저장 완료", webList.size());
        }

        if ("Y".equalsIgnoreCase(app.getSmsUseAt())) {
            log.info("SMS 대상자 처리 예정");
        }
    }

    /**
     * Step 5 - 발송 건수 집계 및 상태 업데이트
     */
    private void updateSendCounts(PushSendRequestDto request, PushSend pushSend, PushApp app) {
        List<PushSendUser> users = pushSendUserRepository.findByAppIdAndNoticeNo(request.getAppId(), pushSend.getNoticeNo());
        int totalCnt = users.size();
        int pushCnt = "Y".equalsIgnoreCase(app.getPushUseAt()) ? totalCnt : 0;
        int smsCnt = "Y".equalsIgnoreCase(app.getSmsUseAt()) ? totalCnt : 0;
        String pushState = request.getReservationDt() != null ? "RESERVED" : "WAIT";

        pushSend.setTotalCnt(totalCnt);
        pushSend.setPushCnt(pushCnt);
        pushSend.setSmsCnt(smsCnt);
        pushSend.setPushState(pushState);

        pushSendRepository.save(pushSend);
        log.info("발송 마스터 상태 및 건수 업데이트 완료 - TOTAL: {}, PUSH: {}, SMS: {}, STATE: {}",
                totalCnt, pushCnt, smsCnt, pushState);
    }

    /**
     * Step 6 - 발송 처리 로그 저장 (T_PUSH_SEND_STACK)
     */
    private void saveSendLog(PushSendRequestDto request, PushSend pushSend) {
        PushSendStack logEntry = PushSendStack.builder()
                .appId(request.getAppId())
                .noticeNo(pushSend.getNoticeNo())
                .stackMsg("발송 요청 수신 및 처리 완료")
                .stackStep("COMPLETE")
                .logDt(LocalDateTime.now())
                .build();

        pushSendStackRepository.save(logEntry);
        log.info("발송 처리 로그 저장 완료");
    }
    private void sendFcmToTargets(PushSendRequestDto request, PushSend pushSend) {
        List<PushSendList> targetList = pushSendListRepository.findByAppIdAndNoticeNo(
                request.getAppId(), pushSend.getNoticeNo());

        for (PushSendList target : targetList) {
            try {
                // 1. 토큰 조회
                Optional<PushAppUserToken> tokenOpt = pushAppUserTokenRepository
                        .findTopByAppIdAndUserIdAndUseAtOrderByTokenIdDesc(target.getAppId(), target.getUserId(), "Y");

                if (tokenOpt.isEmpty()) {
                    target.setSuccessYn("N");
                    target.setFailMsg("FCM 토큰 없음");
                    continue;
                }

                String token = tokenOpt.get().getFcmToken();

                // 2. FCM 발송
                fcmService.sendTo(token, request.getNoticeTitle(), request.getNoticeBody());

                // 3. 성공 처리
                target.setSuccessYn("Y");
                target.setSendDt(String.valueOf(LocalDateTime.now()));
            } catch (Exception e) {
                // 4. 실패 처리
                target.setSuccessYn("N");
                target.setFailMsg(e.getMessage());
            }
        }

        pushSendListRepository.saveAll(targetList);
        log.info("FCM 발송 대상 {}명 처리 완료", targetList.size());
    }

}
