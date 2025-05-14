package com.nanwe.push.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushCodeDto {

    private Long codeId;
    private String grpCd;
    private String code;
    private String codeNm;
    private Integer sortOrdr;
    private String useAt;
}
