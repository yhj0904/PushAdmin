package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 발송 사용자 결과 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 대상자 및 성공 여부 정보를 담는 DTO")
public class PushSendUserDto {

    @Schema(description = "발송 대상 시퀀스 (Primary Key)")
    private Long sendSeq;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "공지사항(푸시) 번호")
    private Long noticeNo;

    @Schema(description = "수신자 사용자 ID")
    private String userId;

    @Schema(description = "성공 여부 (Y/N)")
    private String successYn;

    @Schema(description = "실패 메시지 (오류 발생 시)")
    private String failMsg;
}
