package com.nanwe.push.service.impl;

import com.nanwe.push.dto.PushSendDetailDto;
import com.nanwe.push.dto.PushSendSearchCondition;
import com.nanwe.push.dto.PushSendSummaryDto;
import com.nanwe.push.dto.PushSendUserDto;
import com.nanwe.push.entity.PushSend;
import com.nanwe.push.mapper.PushSendMapper;
import com.nanwe.push.repository.PushSendRepository;
import com.nanwe.push.repository.PushSendUserRepository;
import com.nanwe.push.service.PushSendQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PushSendQueryServiceImpl implements PushSendQueryService {

    private final PushSendMapper pushSendMapper;
    private final PushSendRepository pushSendRepository;
    private final PushSendUserRepository pushSendUserRepository;

    @Override
    public Page<PushSendSummaryDto> getPushHistory(
            PushSendSearchCondition cond, Pageable pageable) {

        int offset = (int) pageable.getOffset();
        int limit  = pageable.getPageSize();

        List<PushSendSummaryDto> content =
                pushSendMapper.searchPushSendList(cond, offset, limit);
        int total = pushSendMapper.countPushSendList(cond);

        return new PageImpl<>(content, pageable, total);
    }


    @Override
    public PushSendDetailDto getPushDetail(String appId, Long noticeNo) {
        Optional<PushSend> sendOpt = pushSendRepository.findByAppIdAndNoticeNo(appId, noticeNo);

        if (sendOpt.isEmpty()) {
            throw new IllegalArgumentException("해당 발송 정보가 존재하지 않습니다.");
        }

        PushSend send = sendOpt.get();

        List<PushSendUserDto> userList = pushSendUserRepository.findByAppIdAndNoticeNo(appId, noticeNo).stream()
                .map(user -> PushSendUserDto.builder()
                        .appId(user.getAppId())
                        .noticeNo(user.getNoticeNo())
                        .userId(user.getUserId())
                        .successYn(user.getSuccessYn())
                        .failMsg(user.getFailMsg())
                        .build())
                .collect(Collectors.toList());

        return PushSendDetailDto.builder()
                .noticeNo(send.getNoticeNo())
                .appId(send.getAppId())
                .noticeTitle(send.getNoticeTitle())
                .noticeBody(send.getNoticeBody())
                .noticeImg(send.getNoticeImg())
                .noticeUrl(send.getNoticeUrl())
                .noticeAction(send.getNoticeAction())
                .noticeDt(send.getNoticeDt())
                .userId(send.getUserId())
                .userNm(send.getUserNm())
                .userMobile(send.getUserMobile())
                .pushUse(send.getPushUse())
                .webUse(send.getWebUse())
                .smsUse(send.getSmsUse())
                .userNmAt(send.getUserNmAt())
                .totalCnt(send.getTotalCnt())
                .pushSuccessCnt(send.getPushSuccessCnt())
                .pushFailCnt(send.getPushFailCnt())
                .pushState(send.getPushState())
                .sendUserList(userList)
                .build();
    }
}
