package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushDeptDto {

    private String deptCd;
    private String deptNm;
    private String deptDv;
    private Integer sortOrdr;
}
