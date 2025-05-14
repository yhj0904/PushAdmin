package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushWebSendListDto {

    private Long webSendId;
    private String appId;
    private Long noticeNo;
    private String userId;
    private String webToken;
    private String sendDt;
    private String successYn;
    private String failMsg;
}
