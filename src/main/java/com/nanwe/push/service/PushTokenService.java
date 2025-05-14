package com.nanwe.push.service;

import com.nanwe.push.dto.FcmTokenDeleteDto;
import com.nanwe.push.dto.FcmTokenRegisterDto;

public interface PushTokenService {
    void registerOrUpdate(FcmTokenRegisterDto dto);
    void deleteByAppIdAndUserIdAndDeviceId(FcmTokenDeleteDto dto);
}

