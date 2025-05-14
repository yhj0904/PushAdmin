package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 관리자 로그인 이력 테이블
 * 로그인한 사용자 ID, IP 주소, 일시를 기록
 */
@Entity
@Table(name = "T_PUSH_LOGIN_LOG")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushLoginLog {

    /**
     * 로그인 로그 고유 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    /**
     * 로그인한 사용자 ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 로그인 일시
     */
    @Column(name = "LOGIN_DT")
    private LocalDateTime loginDt;

    /**
     * 로그인한 클라이언트 IP
     */
    @Column(name = "LOGIN_IP")
    private String loginIp;
}
