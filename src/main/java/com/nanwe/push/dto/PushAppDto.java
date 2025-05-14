package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushAppDto {

    private String appId;
    private String fcmHttpV1At;
    private String fcmApiKey;
    private String fcmV1Config;
    private String pushUseAt;
    private String smsUseAt;
    private String webUseAt;
    private String useAt;
}
