package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendListDto {

    private Long sendListId;
    private String appId;
    private Long noticeNo;
    private String userId;
    private String userNm;
    private String successYn;
    private String failMsg;
    private String sendDt;
}
