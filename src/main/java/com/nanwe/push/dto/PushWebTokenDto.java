package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 웹 푸시 구독 토큰 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "웹 브라우저 푸시 구독 정보를 담는 DTO")
public class PushWebTokenDto {

    @Schema(description = "웹 푸시 토큰 ID (Primary Key)")
    private Long tokenId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "사용자 ID")
    private String userId;

    @Schema(description = "웹 푸시 endpoint URL")
    private String endpoint;

    @Schema(description = "Web Push 공개 키 (p256dh)")
    private String keyP256dh;

    @Schema(description = "Web Push 인증 키 (auth)")
    private String auth;

    @Schema(description = "등록 일시")
    private LocalDateTime regDt;

    @Schema(description = "사용 여부 (Y/N)")
    private String useAt;
}
