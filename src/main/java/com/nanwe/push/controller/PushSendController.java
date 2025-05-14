package com.nanwe.push.controller;

import com.nanwe.push.dto.PushSendRequestDto;
import com.nanwe.push.service.PushSendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Push 발송", description = "푸시 발송 API")
@RestController
@RequestMapping("/api/push")
@RequiredArgsConstructor
public class PushSendController {

    private final PushSendService pushSendService;

    @Operation(summary = "푸시 발송 요청", description = "푸시, 웹푸시, SMS 발송을 위한 요청을 처리합니다.")
    @PostMapping("/send")
    public ResponseEntity<Void> sendPush(@RequestBody PushSendRequestDto request) {
        pushSendService.sendPush(request);
        return ResponseEntity.ok().build();
    }
}
