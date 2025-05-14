package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 웹 푸시 발송 대상 사용자 이력 테이블
 * 사용자별 웹 푸시 전송 결과 및 실패 메시지를 저장
 */
@Entity
@Table(name = "T_PUSH_WEB_SEND_USER")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushWebSendUser {

    /**
     * 웹 푸시 발송 시퀀스 (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEND_SEQ")
    private Long sendSeq;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 푸시 공지 번호
     */
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    /**
     * 사용자 ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 웹 푸시 토큰
     */
    @Column(name = "WEB_TOKEN")
    private String webToken;

    /**
     * 발송 성공 여부 (Y/N)
     */
    @Column(name = "SUCCESS_YN")
    private String successYn;

    /**
     * 실패 메시지
     */
    @Column(name = "FAIL_MSG")
    private String failMsg;

    /**
     * 발송 일시
     */
    @Column(name = "SEND_DT")
    private String sendDt;
}
