package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 푸시 발송 처리 로그 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 처리 과정의 단계별 로그 메시지를 담는 DTO")
public class PushSendStackDto {

    @Schema(description = "로그 스택 ID (Primary Key)")
    private Long stackId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "공지사항(푸시) 번호")
    private Long noticeNo;

    @Schema(description = "로그 메시지 (처리 내용)")
    private String stackMsg;

    @Schema(description = "처리 단계 구분 값 (예: TOKEN, BUILD, SEND)")
    private String stackStep;

    @Schema(description = "로그 기록 일시")
    private LocalDateTime logDt;
}
