package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 사용자 그룹 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 사용자 그룹 마스터 정보를 담는 DTO")
public class PushGroupDto {

    @Schema(description = "그룹 ID (Primary Key)")
    private Long grpId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "그룹 이름 (예: 마케팅 수신자)")
    private String grpNm;

    @Schema(description = "부서 코드 (그룹 소속 기준)")
    private String deptCd;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "부서 구분")
    private String deptDv;

    @Schema(description = "정렬 순서")
    private Integer sortOrdr;
}
