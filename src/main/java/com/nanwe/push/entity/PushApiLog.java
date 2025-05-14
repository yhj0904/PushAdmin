package com.nanwe.push.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 외부 시스템에서 요청한 푸시 API 이력을 저장하는 테이블
 * 요청 URL, 요청/응답 본문, 상태 코드, 등록일시 등을 기록
 */
@Entity
@Table(name = "T_PUSH_API_LOG")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushApiLog {

    /**
     * 로그 고유 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    /**
     * 요청 대상 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 요청 URL
     */
    @Column(name = "REQ_URL")
    private String reqUrl;

    /**
     * 요청 본문 (JSON)
     */
    @Column(name = "REQ_BODY")
    private String reqBody;

    /**
     * 응답 본문 (JSON 또는 메시지)
     */
    @Column(name = "RES_BODY")
    private String resBody;

    /**
     * 요청 처리 상태 (예: SUCCESS, FAIL)
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 등록 일시
     */
    @Column(name = "REG_DT")
    private LocalDateTime regDt;
}
