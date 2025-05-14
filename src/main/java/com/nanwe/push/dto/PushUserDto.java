package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 사용자 기본 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 시스템에 등록된 사용자 정보를 담는 DTO")
public class PushUserDto {

    @Schema(description = "사용자 ID (Primary Key)")
    private String userId;

    @Schema(description = "사용자 이름")
    private String userNm;

    @Schema(description = "사용자 휴대폰 번호")
    private String userMobile;

    @Schema(description = "부서 코드")
    private String deptCd;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "부서 구분 (예: 본부, 팀)")
    private String deptDv;

    @Schema(description = "정렬 순서")
    private Integer sortOrdr;
}
