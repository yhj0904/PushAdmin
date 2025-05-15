package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 요약 정보 DTO")
public class PushSendSummaryDto {

    @Schema(description = "발송 고유 번호 (NOTICE_NO, PK)", example = "1001")
    private Long noticeNo;

    @Schema(description = "앱 ID", example = "PUSH_MGR")
    private String appId;

    @Schema(description = "제목", example = "긴급 공지사항")
    private String noticeTitle;

    @Schema(description = "발송 예정 일시 또는 즉시 발송 시 현재 시각", example = "2025-05-15T10:00:00")
    private LocalDateTime noticeDt;

    @Schema(description = "등록자 ID", example = "admin")
    private String userId;

    @Schema(description = "등록자 이름", example = "관리자")
    private String userNm;

    @Schema(description = "푸시 사용 여부", example = "Y")
    private String pushUse;

    @Schema(description = "웹 푸시 사용 여부", example = "N")
    private String webUse;

    @Schema(description = "SMS 사용 여부", example = "N")
    private String smsUse;

    @Schema(description = "총 대상자 수", example = "50")
    private Integer totalCnt;

    @Schema(description = "푸시 성공 수", example = "45")
    private Integer pushSuccessCnt;

    @Schema(description = "푸시 실패 수", example = "5")
    private Integer pushFailCnt;

    @Schema(description = "현재 상태 (WAIT, RESERVED, COMPLETED 등)", example = "COMPLETED")
    private String pushState;
}
