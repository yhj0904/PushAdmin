package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 푸시 발송 대상자 이력 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 메시지가 발송된 대상자 목록과 결과 정보를 담는 DTO")
public class PushSendListDto {

    @Schema(description = "발송 대상 시퀀스 ID (Primary Key)")
    private Long sendListId;

    @Schema(description = "앱 ID")
    private String appId;

    @Schema(description = "공지사항(푸시) 번호")
    private Long noticeNo;

    @Schema(description = "사용자 ID")
    private String userId;

    @Schema(description = "사용자 이름")
    private String userNm;

    @Schema(description = "성공 여부 (Y/N)")
    private String successYn;

    @Schema(description = "실패 메시지 (오류 발생 시)")
    private String failMsg;

    @Schema(description = "발송 일시")
    private String sendDt;
}
