package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Spring Session 저장 테이블
 * 사용자 세션 정보를 DB에 저장하여 세션 클러스터링을 지원
 */
@Entity
@Table(name = "SPRING_SESSION")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpringSession {

    /**
     * 내부 UUID 기반 Primary Key
     */
    @Id
    @Column(name = "PRIMARY_ID")
    private String primaryId;

    /**
     * 외부에서 접근하는 세션 ID (JSESSIONID)
     */
    @Column(name = "SESSION_ID", unique = true, nullable = false)
    private String sessionId;

    /**
     * 세션 생성 시각 (epoch milliseconds)
     */
    @Column(name = "CREATION_TIME", nullable = false)
    private Instant creationTime;

    /**
     * 마지막 요청 시각
     */
    @Column(name = "LAST_ACCESS_TIME", nullable = false)
    private Instant lastAccessTime;

    /**
     * 최대 비활성 간격 (초)
     */
    @Column(name = "MAX_INACTIVE_INTERVAL", nullable = false)
    private Integer maxInactiveInterval;

    /**
     * 만료 예정 시각
     */
    @Column(name = "EXPIRY_TIME", nullable = false)
    private Instant expiryTime;

    /**
     * 세션에 연관된 사용자 이름 (인증 사용자)
     */
    @Column(name = "PRINCIPAL_NAME")
    private String principalName;
}
