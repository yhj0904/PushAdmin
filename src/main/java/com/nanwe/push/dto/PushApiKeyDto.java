package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushApiKeyDto {

    private Long apiKeyId;
    private String appId;
    private String apiKey;
    private String useAt;
    private LocalDateTime regDt;
}
