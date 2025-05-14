package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 앱 마스터 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 앱 등록 및 설정 정보를 담는 DTO")
public class PushAppDto {

    @Schema(description = "앱 ID (Primary Key)")
    private String appId;

    @Schema(description = "FCM V1 HTTP 프로토콜 사용 여부 (Y/N)")
    private String fcmHttpV1At;

    @Schema(description = "FCM API Key (V1 이전 방식용)")
    private String fcmApiKey;

    @Schema(description = "FCM V1 서비스 계정 JSON 문자열")
    private String fcmV1Config;

    @Schema(description = "푸시 사용 여부 (Y/N)")
    private String pushUseAt;

    @Schema(description = "SMS 사용 여부 (Y/N)")
    private String smsUseAt;

    @Schema(description = "웹 푸시 사용 여부 (Y/N)")
    private String webUseAt;

    @Schema(description = "앱 사용 여부 (Y/N)")
    private String useAt;
}
