package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendStackDto {

    private Long stackId;
    private String appId;
    private Long noticeNo;
    private String stackMsg;
    private String stackStep;
    private LocalDateTime logDt;
}
