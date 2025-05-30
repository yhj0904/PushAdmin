package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 앱 사용자 푸시 토큰 테이블
 * 사용자별 디바이스 ID와 FCM 토큰을 저장
 */
@Entity
@Table(name = "T_PUSH_APP_USER_TOKEN")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushAppUserToken {

    /**
     * 토큰 고유 ID (Primary Key)
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
     * 디바이스 고유 식별자
     */
    @Column(name = "DEVICE_ID")
    private String deviceId;

    /**
     * FCM 푸시 토큰
     */
    @Column(name = "FCM_TOKEN")
    private String fcmToken;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "APP_ID",  referencedColumnName = "APP_ID",  insertable = false, updatable = false),
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(name = "fk_push_token_app_user"))
    private PushAppUser appUser;

}
