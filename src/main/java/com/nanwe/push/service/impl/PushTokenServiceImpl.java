package com.nanwe.push.service.impl;

import com.nanwe.push.dto.FcmTokenDeleteDto;
import com.nanwe.push.dto.FcmTokenRegisterDto;
import com.nanwe.push.entity.PushAppUser;
import com.nanwe.push.entity.PushAppUserToken;
import com.nanwe.push.repository.PushAppUserTokenRepository;
import com.nanwe.push.service.PushTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PushTokenServiceImpl implements PushTokenService {

    private final PushAppUserTokenRepository tokenRepository;

    @Transactional
    @Override
    public void registerOrUpdate(FcmTokenRegisterDto dto) {

        PushAppUserToken token = tokenRepository
                .findTopByAppIdAndUserIdAndDeviceIdOrderByTokenIdDesc(dto.getAppId(), dto.getUserId(), dto.getDeviceId())
                .orElseGet(() -> PushAppUserToken.builder()
                        .appId(dto.getAppId())
                        .userId(dto.getUserId())
                        .deviceId(dto.getDeviceId())
                        .regDt(LocalDateTime.now())
                        .build());

        token.setFcmToken(dto.getFcmToken());
        token.setUseAt("Y");
        token.setRegDt(LocalDateTime.now());

        tokenRepository.save(token);
        log.info("FCM 토큰 등록 또는 갱신 완료: {}", token.getFcmToken());
    }

    public void deleteByAppIdAndUserIdAndDeviceId(FcmTokenDeleteDto dto) {
        Optional<PushAppUserToken> tokenOpt = tokenRepository.findByAppIdAndUserIdAndDeviceId(
                dto.getAppId(), dto.getUserId(), dto.getDeviceId());

        if (tokenOpt.isPresent()) {
            PushAppUserToken token = tokenOpt.get();
            token.setUseAt("N");
            token.setFcmToken(null);
            token.setRegDt(LocalDateTime.now());
            tokenRepository.save(token);
            log.info("FCM 토큰 삭제 처리 완료: {}, {}", dto.getUserId(), dto.getDeviceId());
        } else {
            log.warn("삭제할 토큰이 존재하지 않음: {}, {}", dto.getUserId(), dto.getDeviceId());
        }
    }

}

