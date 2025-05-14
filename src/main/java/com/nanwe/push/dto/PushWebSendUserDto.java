package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 웹 푸시 개별 수신자 발송 결과 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "웹 푸시가 개별 사용자에게 발송된 결과 정보를 담는 DTO")
public class PushWebSendUserDto {

    @Schema(description = "웹 푸시 발송 시퀀스 ID (Primary Key)")
    private Long sendSeq;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "공지사항(푸시) 번호")
    private Long noticeNo;

    @Schema(description = "수신자 사용자 ID")
    private String userId;

    @Schema(description = "웹 푸시 토큰 (endpoint)")
    private String webToken;

    @Schema(description = "성공 여부 (Y/N)")
    private String successYn;

    @Schema(description = "실패 메시지 (오류 발생 시)")
    private String failMsg;

    @Schema(description = "발송 일시")
    private String sendDt;
}
