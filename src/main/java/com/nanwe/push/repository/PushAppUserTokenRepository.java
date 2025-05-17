package com.nanwe.push.repository;

import com.nanwe.push.entity.PushAppUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PushAppUserTokenRepository extends JpaRepository<PushAppUserToken, Long> {
    Optional<PushAppUserToken> findTopByAppIdAndUserIdAndDeviceIdOrderByTokenIdDesc (String appId, String userId, String deviceId);
    Optional<PushAppUserToken> findTopByAppIdAndUserIdAndUseAtOrderByTokenIdDesc(String appId, String userId, String useAt);
    Optional<PushAppUserToken> findByAppIdAndUserIdAndDeviceId(String appId, String userId, String deviceId);
}


