package com.nanwe.push.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/push")
public class PushController {
    // 인증 필요한 API
}