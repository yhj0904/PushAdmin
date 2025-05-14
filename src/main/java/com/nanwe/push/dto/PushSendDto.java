package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 푸시 발송 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 요청 및 결과 정보를 담는 DTO")
public class PushSendDto {

    @Schema(description = "공지사항 고유번호 (PK)")
    private Long noticeNo;

    @Schema(description = "발송 대상 앱 ID (T_PUSH_APP_M.APP_ID)")
    private String appId;

    @Schema(description = "푸시 제목 (예: 서비스 점검 안내)")
    private String noticeTitle;

    @Schema(description = "푸시 본문 내용")
    private String noticeBody;

    @Schema(description = "푸시 이미지 URL (옵션)")
    private String noticeImg;

    @Schema(description = "푸시 클릭 시 이동할 URL")
    private String noticeUrl;

    @Schema(description = "푸시 클릭 시 앱에서 실행할 액션 명령어")
    private String noticeAction;

    @Schema(description = "발송 등록자 ID")
    private String userId;

    @Schema(description = "발송 등록자 이름")
    private String userNm;

    @Schema(description = "발송 등록자 휴대폰 번호")
    private String userMobile;

    @Schema(description = "푸시 등록(발송 요청) 일시")
    private LocalDateTime noticeDt;

    @Schema(description = "푸시 발송 사용 여부 (Y/N)")
    private String pushUse;

    @Schema(description = "푸시 발송 대상자 수")
    private Integer pushCnt;

    @Schema(description = "푸시 성공 발송 건수")
    private Integer pushSuccessCnt;

    @Schema(description = "푸시 실패 건수")
    private Integer pushFailCnt;

    @Schema(description = "SMS 사용 여부 (Y/N)")
    private String smsUse;

    @Schema(description = "SMS 발송 대상자 수")
    private Integer smsCnt;

    @Schema(description = "SMS 성공 건수")
    private Integer smsSuccessCnt;

    @Schema(description = "SMS 실패 건수")
    private Integer smsFailCnt;

    @Schema(description = "웹 푸시 사용 여부 (Y/N)")
    private String webUse;

    @Schema(description = "총 발송 대상자 수")
    private Integer totalCnt;

    @Schema(description = "예약 발송 일시")
    private LocalDateTime reservationDt;

    @Schema(description = "푸시 상태 (WAIT, DONE, FAIL 등)")
    private String pushState;

    @Schema(description = "사용자 이름 포함 여부 (Y/N)")
    private String userNmAt;
}
