package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendItemDto {

    private Long itemId;
    private String appId;
    private Long noticeNo;
    private String userId;
    private String sendResult;
    private String sendMsg;
    private LocalDateTime sendDt;
}
