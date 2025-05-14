package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 사용자 그룹 구성원 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 사용자 그룹에 소속된 개별 사용자 정보를 담는 DTO")
public class PushGroupUserDto {

    @Schema(description = "그룹 사용자 매핑 ID (Primary Key)")
    private Long grpUserId;

    @Schema(description = "그룹 ID (T_PUSH_GRP_M.GRP_ID)")
    private Long grpId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "사용자 ID")
    private String userId;

    @Schema(description = "사용자 이름")
    private String userNm;

    @Schema(description = "부서 코드")
    private String deptCd;

    @Schema(description = "부서명")
    private String deptNm;

    @Schema(description = "부서 구분")
    private String deptDv;
}
