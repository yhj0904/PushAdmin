package com.nanwe.push.controller;

import com.nanwe.push.dto.FcmTokenDeleteDto;
import com.nanwe.push.dto.FcmTokenRegisterDto;
import com.nanwe.push.service.PushTokenService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class PushTokenController {

    private final PushTokenService pushTokenService;

    @PostMapping("/register")
    @Operation(summary = "FCM 토큰 등록/업데이트")
    public ResponseEntity<Void> register(@RequestBody FcmTokenRegisterDto dto) {
        pushTokenService.registerOrUpdate(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "FCM 토큰 삭제")
    public ResponseEntity<Void> deleteToken(@RequestBody FcmTokenDeleteDto dto) {
        pushTokenService.deleteByAppIdAndUserIdAndDeviceId(dto);
        return ResponseEntity.ok().build();
    }

}
