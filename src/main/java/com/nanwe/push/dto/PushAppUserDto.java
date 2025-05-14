package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushAppUserDto {

    private String userId;
    private String appId;
    private String agreeAt;
    private String allRcveAt;
    private String indvRcveAt;
}
