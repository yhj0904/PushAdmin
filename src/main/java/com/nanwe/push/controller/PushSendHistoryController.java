package com.nanwe.push.controller;

import com.nanwe.push.dto.PushSendDetailDto;
import com.nanwe.push.dto.PushSendSearchCondition;
import com.nanwe.push.dto.PushSendSummaryDto;
import com.nanwe.push.service.PushSendQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Tag(name = "푸시 발송 이력", description = "발송 이력 목록 및 상세 조회")
@RestController
@RequestMapping("/api/push/history")
@RequiredArgsConstructor
public class PushSendHistoryController {

    private final PushSendQueryService pushSendQueryService;

    /**
     * 발송 이력 목록 조회 (페이징 + 검색조건 확장)
     */
    @Operation(summary = "발송 목록 조회", description = "앱 ID와 다양한 조건으로 푸시 발송 목록을 조회합니다.")
    @GetMapping("/{appId}")
    public ResponseEntity<Page<PushSendSummaryDto>> getPushHistory(
            @PathVariable String appId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String pushState,
            @RequestParam(required = false) @Parameter(description = "조회 시작일 (예: 2025-05-01T00:00:00)") LocalDateTime fromDt,
            @RequestParam(required = false) @Parameter(description = "조회 종료일 (예: 2025-05-31T23:59:59)") LocalDateTime toDt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PushSendSearchCondition cond = PushSendSearchCondition.builder()
                .appId(appId)
                .keyword(keyword)
                .pushState(pushState)
                .fromDt(fromDt)
                .toDt(toDt)
                .build();

        Pageable pageable = PageRequest.of(page, size);
        Page<PushSendSummaryDto> result = pushSendQueryService.getPushHistory(cond, pageable);
        return ResponseEntity.ok(result);
    }

    /**
     * 발송 상세 조회 (발송 대상자 포함)
     */
    @Operation(summary = "발송 상세 조회", description = "발송 번호에 해당하는 상세 내용과 대상자 목록을 함께 조회합니다.")
    @GetMapping("/{appId}/{noticeNo}")
    public ResponseEntity<PushSendDetailDto> getPushDetail(
            @PathVariable String appId,
            @PathVariable Long noticeNo) {

        PushSendDetailDto detail = pushSendQueryService.getPushDetail(appId, noticeNo);
        return ResponseEntity.ok(detail);
    }
}