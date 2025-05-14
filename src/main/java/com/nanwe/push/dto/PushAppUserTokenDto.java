package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushAppUserTokenDto {

    private Long tokenId;
    private String appId;
    private String userId;
    private String deviceId;
    private String fcmToken;
    private LocalDateTime regDt;
    private String useAt;
}
