package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 목록 검색 조건 DTO")
public class PushSendSearchCondition {

    @Schema(description = "앱 ID", example = "PUSH_MGR")
    private String appId;

    @Schema(description = "검색 키워드 (제목/작성자명 등 포함 검색)", example = "긴급")
    private String keyword;

    @Schema(description = "발송 상태 필터 (WAIT, RESERVED, COMPLETED 등)", example = "COMPLETED")
    private String pushState;

    @Schema(description = "조회 시작일 (발송일 기준)", example = "2025-05-01T00:00:00")
    private LocalDateTime fromDt;

    @Schema(description = "조회 종료일 (발송일 기준)", example = "2025-05-31T23:59:59")
    private LocalDateTime toDt;
}
