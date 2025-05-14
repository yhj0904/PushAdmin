package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 앱 사용자 푸시 토큰 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "앱 사용자별 디바이스 FCM 푸시 토큰 정보를 담는 DTO")
public class PushAppUserTokenDto {

    @Schema(description = "토큰 ID (Primary Key)")
    private Long tokenId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "사용자 ID")
    private String userId;

    @Schema(description = "디바이스 고유 ID")
    private String deviceId;

    @Schema(description = "Firebase FCM 푸시 토큰")
    private String fcmToken;

    @Schema(description = "등록 일시")
    private LocalDateTime regDt;

    @Schema(description = "사용 여부 (Y/N)")
    private String useAt;
}
