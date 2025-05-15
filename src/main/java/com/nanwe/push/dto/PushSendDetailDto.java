package com.nanwe.push.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "푸시 발송 상세 정보 DTO")
public class PushSendDetailDto {

    @Schema(description = "발송 고유 번호 (NOTICE_NO, PK)", example = "1001")
    private Long noticeNo;

    @Schema(description = "앱 ID", example = "PUSH_MGR")
    private String appId;

    @Schema(description = "공지 제목", example = "업데이트 안내")
    private String noticeTitle;

    @Schema(description = "공지 내용", example = "새로운 기능이 추가되었습니다.")
    private String noticeBody;

    @Schema(description = "공지 이미지 URL", example = "https://cdn.example.com/notice.jpg")
    private String noticeImg;

    @Schema(description = "공지 클릭 시 이동 URL", example = "https://example.com")
    private String noticeUrl;

    @Schema(description = "앱에서 수행할 액션명", example = "OPEN_APP")
    private String noticeAction;

    @Schema(description = "발송 예정 일시", example = "2025-05-15T10:00:00")
    private LocalDateTime noticeDt;

    @Schema(description = "등록자 ID", example = "admin")
    private String userId;

    @Schema(description = "등록자 이름", example = "관리자")
    private String userNm;

    @Schema(description = "등록자 연락처", example = "01012345678")
    private String userMobile;

    @Schema(description = "푸시 사용 여부", example = "Y")
    private String pushUse;

    @Schema(description = "웹 푸시 사용 여부", example = "N")
    private String webUse;

    @Schema(description = "SMS 사용 여부", example = "N")
    private String smsUse;

    @Schema(description = "수신자 이름 포함 여부", example = "Y")
    private String userNmAt;

    @Schema(description = "총 발송 대상 수", example = "100")
    private Integer totalCnt;

    @Schema(description = "푸시 성공 수", example = "97")
    private Integer pushSuccessCnt;

    @Schema(description = "푸시 실패 수", example = "3")
    private Integer pushFailCnt;

    @Schema(description = "푸시 발송 상태 (WAIT, RESERVED, COMPLETED)", example = "COMPLETED")
    private String pushState;

    @Schema(description = "발송 대상 사용자 목록")
    private List<PushSendUserDto> sendUserList;

}
