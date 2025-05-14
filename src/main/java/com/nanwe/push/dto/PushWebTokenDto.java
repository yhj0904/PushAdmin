package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushWebTokenDto {

    private Long tokenId;
    private String appId;
    private String userId;
    private String endpoint;
    private String keyP256dh;
    private String auth;
    private LocalDateTime regDt;
    private String useAt;
}
