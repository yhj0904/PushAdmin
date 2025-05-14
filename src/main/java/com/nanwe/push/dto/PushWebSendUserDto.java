package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushWebSendUserDto {

    private Long sendSeq;
    private String appId;
    private Long noticeNo;
    private String userId;
    private String webToken;
    private String successYn;
    private String failMsg;
    private String sendDt;
}
