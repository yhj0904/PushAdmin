package com.nanwe.push.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 푸시 발송 항목 테이블
 * 개별 사용자에 대한 푸시 발송 메시지 및 결과를 저장
 */
@Entity
@Table(name = "T_PUSH_SEND_ITEM")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushSendItem {

    /**
     * 발송 항목 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long itemId;

    /**
     * 앱 ID
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 공지사항(푸시) 번호
     */
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    /**
     * 수신자 사용자 ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 발송 결과 (성공/실패/예외 등)
     */
    @Column(name = "SEND_RESULT")
    private String sendResult;

    /**
     * 발송된 메시지 내용
     */
    @Column(name = "SEND_MSG")
    private String sendMsg;

    /**
     * 발송 일시
     */
    @Column(name = "SEND_DT")
    private LocalDateTime sendDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "APP_ID", referencedColumnName = "APP_ID", insertable = false, updatable = false),
            @JoinColumn(name = "NOTICE_NO", referencedColumnName = "NOTICE_NO", insertable = false, updatable = false)
    })
    private PushSend pushSend;

}
