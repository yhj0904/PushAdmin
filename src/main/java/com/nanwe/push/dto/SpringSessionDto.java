package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;

/**
 * Spring Session 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Spring JDBC 기반 세션 저장소의 세션 정보를 담는 DTO")
public class SpringSessionDto {

    @Schema(description = "세션 기본 키 (Primary Key, 내부 UUID)")
    private String primaryId;

    @Schema(description = "HTTP 세션 ID (JSESSIONID)")
    private String sessionId;

    @Schema(description = "세션 생성 시각 (epoch millis 기준)")
    private Instant creationTime;

    @Schema(description = "마지막 접근 시각")
    private Instant lastAccessTime;

    @Schema(description = "최대 비활성 간격 (초 단위)")
    private Integer maxInactiveInterval;

    @Schema(description = "세션 만료 예정 시각")
    private Instant expiryTime;

    @Schema(description = "인증된 사용자 이름 (PRINCIPAL_NAME)")
    private String principalName;
}
