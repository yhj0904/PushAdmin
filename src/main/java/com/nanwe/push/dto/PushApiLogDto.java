package com.nanwe.push.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushApiLogDto {

    private Long logId;
    private String appId;
    private String reqUrl;
    private String reqBody;
    private String resBody;
    private String status;
    private LocalDateTime regDt;
}
