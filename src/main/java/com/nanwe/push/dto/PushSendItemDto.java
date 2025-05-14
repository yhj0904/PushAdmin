package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 개별 푸시 발송 항목 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 시 개별 사용자에게 발송된 메시지 및 결과 정보를 담는 DTO")
public class PushSendItemDto {

    @Schema(description = "발송 항목 ID (Primary Key)")
    private Long itemId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "공지사항(푸시) 번호")
    private Long noticeNo;

    @Schema(description = "수신자 사용자 ID")
    private String userId;

    @Schema(description = "발송 결과 (예: SUCCESS, FAIL, TIMEOUT)")
    private String sendResult;

    @Schema(description = "실제 발송된 메시지 내용")
    private String sendMsg;

    @Schema(description = "발송 일시")
    private LocalDateTime sendDt;
}
