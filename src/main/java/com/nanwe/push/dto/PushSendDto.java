package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendDto {

    private Long noticeNo;
    private String appId;
    private String noticeTitle;
    private String noticeBody;
    private String noticeImg;
    private String noticeUrl;
    private String noticeAction;
    private String userId;
    private String userNm;
    private String userMobile;
    private LocalDateTime noticeDt;
    private String pushUse;
    private Integer pushCnt;
    private Integer pushSuccessCnt;
    private Integer pushFailCnt;
    private String smsUse;
    private Integer smsCnt;
    private Integer smsSuccessCnt;
    private Integer smsFailCnt;
    private String webUse;
    private Integer totalCnt;
    private LocalDateTime reservationDt;
    private String pushState;
    private String userNmAt;
}
