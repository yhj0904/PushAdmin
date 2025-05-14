package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 관리자 로그인 이력 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 관리자 로그인 이력을 담는 DTO")
public class PushLoginLogDto {

    @Schema(description = "로그 ID (Primary Key)")
    private Long logId;

    @Schema(description = "로그인한 사용자 ID")
    private String userId;

    @Schema(description = "로그인 일시")
    private LocalDateTime loginDt;

    @Schema(description = "로그인한 클라이언트 IP 주소")
    private String loginIp;
}
