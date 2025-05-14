package com.nanwe.push.service;

import com.nanwe.push.dto.PushSendRequestDto;

public interface PushSendService {

    /**
     * 푸시 발송 요청 처리
     * @param request 푸시 요청 DTO
     */
    void sendPush(PushSendRequestDto request);
}
