package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 웹 푸시 토큰 테이블
 * 사용자 브라우저의 Web Push 토큰 정보를 저장
 */
@Entity
@Table(name = "T_PUSH_WEB_TOKEN")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushWebToken {

    /**
     * 토큰 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_ID")
    private Long tokenId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 사용자 ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 웹 푸시 endpoint
     */
    @Column(name = "ENDPOINT")
    private String endpoint;

    /**
     * 공개 키 (P256dh)
     */
    @Column(name = "KEY_P256DH")
    private String keyP256dh;

    /**
     * 인증 키 (auth)
     */
    @Column(name = "AUTH")
    private String auth;

    /**
     * 등록 일시
     */
    @Column(name = "REG_DT")
    private LocalDateTime regDt;

    /**
     * 사용 여부 (Y/N)
     */
    @Column(name = "USE_AT")
    private String useAt;
}
