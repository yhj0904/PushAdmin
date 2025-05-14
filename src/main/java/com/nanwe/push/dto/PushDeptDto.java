package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 부서 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "조직의 부서 코드 및 명칭 정보를 담는 DTO")
public class PushDeptDto {

    @Schema(description = "부서 코드 (Primary Key)")
    private String deptCd;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "부서 구분 (예: 본부, 팀 등)")
    private String deptDv;

    @Schema(description = "부서 정렬 순서")
    private Integer sortOrdr;
}
