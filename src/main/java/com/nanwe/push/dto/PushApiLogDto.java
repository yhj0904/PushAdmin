package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 외부 API 호출 이력 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "외부 시스템이 푸시 API를 호출한 이력을 담는 DTO")
public class PushApiLogDto {

    @Schema(description = "로그 ID (Primary Key)")
    private Long logId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "API 요청 URL")
    private String reqUrl;

    @Schema(description = "요청 본문 (JSON 문자열 등)")
    private String reqBody;

    @Schema(description = "응답 본문 (JSON 또는 응답 메시지)")
    private String resBody;

    @Schema(description = "응답 상태 (예: SUCCESS, ERROR)")
    private String status;

    @Schema(description = "로그 생성 시각")
    private LocalDateTime regDt;
}
