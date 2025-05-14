package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 외부 API 호출용 인증 키 관리 테이블
 * 앱별로 발급된 API 키 및 사용 여부를 저장
 */
@Entity
@Table(name = "T_PUSH_API_KEY")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushApiKey {

    /**
     * API 키 고유 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API_KEY_ID")
    private Long apiKeyId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 외부 호출용 API 키
     */
    @Column(name = "API_KEY")
    private String apiKey;

    /**
     * 사용 여부 (Y/N)
     */
    @Column(name = "USE_AT")
    private String useAt;

    /**
     * 등록 일시
     */
    @Column(name = "REG_DT")
    private LocalDateTime regDt;
}
