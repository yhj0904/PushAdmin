package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 공통 코드 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "시스템 내에서 사용하는 공통 코드 정보를 담는 DTO")
public class PushCodeDto {

    @Schema(description = "코드 ID (Primary Key)")
    private Long codeId;

    @Schema(description = "코드 그룹 (예: PUSH_STATE, MESSAGE_TYPE)")
    private String grpCd;

    @Schema(description = "코드 값")
    private String code;

    @Schema(description = "코드 이름 또는 설명")
    private String codeNm;

    @Schema(description = "정렬 순서")
    private Integer sortOrdr;

    @Schema(description = "사용 여부 (Y/N)")
    private String useAt;
}
