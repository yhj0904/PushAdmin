package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushGroupDto {

    private Long grpId;
    private String appId;
    private String grpNm;
    private String deptCd;
    private String deptNm;
    private String deptDv;
    private Integer sortOrdr;
}
