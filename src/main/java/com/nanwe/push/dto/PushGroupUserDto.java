package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushGroupUserDto {

    private Long grpUserId;
    private Long grpId;
    private String appId;
    private String userId;
    private String userNm;
    private String deptCd;
    private String deptNm;
    private String deptDv;
}
