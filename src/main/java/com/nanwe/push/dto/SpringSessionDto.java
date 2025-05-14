package com.nanwe.push.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpringSessionDto {

    private String primaryId;
    private String sessionId;
    private Instant creationTime;
    private Instant lastAccessTime;
    private Integer maxInactiveInterval;
    private Instant expiryTime;
    private String principalName;
}
