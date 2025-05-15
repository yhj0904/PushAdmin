package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 대상 사용자 DTO")
public class PushSendUserDto {

    @Schema(description = "앱 ID", example = "PUSH_MGR")
    private String appId;

    @Schema(description = "발송 번호", example = "1001")
    private Long noticeNo;

    @Schema(description = "사용자 ID", example = "user01")
    private String userId;

    @Schema(description = "발송 성공 여부 (Y/N)", example = "Y")
    private String successYn;

    @Schema(description = "실패 사유 (성공 시 null)", example = "FCM 토큰 없음")
    private String failMsg;
}
