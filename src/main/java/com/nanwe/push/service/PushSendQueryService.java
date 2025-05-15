package com.nanwe.push.service;

import com.nanwe.push.dto.PushSendDetailDto;
import com.nanwe.push.dto.PushSendSummaryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PushSendQueryService {

    /**
     * 특정 앱 ID에 대한 발송 목록 조회 (페이징)
     */
    Page<PushSendSummaryDto> getPushHistory(String appId, Pageable pageable);

    /**
     * 특정 발송 번호에 대한 상세 내용 조회 (대상자 포함)
     */
    PushSendDetailDto getPushDetail(String appId, Long noticeNo);
}
