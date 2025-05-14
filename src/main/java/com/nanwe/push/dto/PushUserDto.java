package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushUserDto {

    private String userId;
    private String userNm;
    private String userMobile;
    private String deptCd;
    private String deptNm;
    private String deptDv;
    private Integer sortOrdr;
}
