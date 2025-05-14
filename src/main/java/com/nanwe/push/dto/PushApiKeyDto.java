package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 외부 API 인증 키 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "외부 시스템에서 푸시 API를 호출할 때 사용하는 인증 키 정보를 담는 DTO")
public class PushApiKeyDto {

    @Schema(description = "API 키 ID (Primary Key)")
    private Long apiKeyId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "API 인증 키 (UUID 형태 등)")
    private String apiKey;

    @Schema(description = "사용 여부 (Y/N)")
    private String useAt;

    @Schema(description = "등록 일시")
    private LocalDateTime regDt;
}
