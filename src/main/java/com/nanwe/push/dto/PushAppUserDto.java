package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 앱 사용자 푸시 수신 설정 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "앱 사용자별 푸시 수신 동의 정보 DTO")
public class PushAppUserDto {

    @Schema(description = "사용자 ID (Primary Key)")
    private String userId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "전체 수신 동의 여부 (Y/N)")
    private String agreeAt;

    @Schema(description = "전체 알림 수신 여부 (Y/N)")
    private String allRcveAt;

    @Schema(description = "개별 알림 수신 여부 (Y/N)")
    private String indvRcveAt;
}
