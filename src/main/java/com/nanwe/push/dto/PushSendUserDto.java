package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendUserDto {

    private Long sendSeq;
    private String appId;
    private Long noticeNo;
    private String userId;
    private String successYn;
    private String failMsg;
}
