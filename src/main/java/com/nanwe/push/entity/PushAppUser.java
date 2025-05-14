package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 앱 사용자 푸시 수신 설정 테이블
 * 각 사용자별 전체 수신 동의, 개별 수신 동의 여부 등을 저장
 */
@Entity
@Table(name = "T_PUSH_APP_USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushAppUser {

    /**
     * 사용자 ID (Primary Key)
     */
    @Id
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 전체 수신 동의 여부 (Y/N)
     */
    @Column(name = "AGREE_AT")
    private String agreeAt;

    /**
     * 전체 메시지 수신 설정 (Y/N)
     */
    @Column(name = "ALL_RCVE_AT")
    private String allRcveAt;

    /**
     * 개별 메시지 수신 설정 (Y/N)
     */
    @Column(name = "INDV_RCVE_AT")
    private String indvRcveAt;
}
