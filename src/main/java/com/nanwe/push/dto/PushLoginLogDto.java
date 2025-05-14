package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushLoginLogDto {

    private Long logId;
    private String userId;
    private LocalDateTime loginDt;
    private String loginIp;
}
