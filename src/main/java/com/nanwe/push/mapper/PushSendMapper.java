package com.nanwe.push.mapper;

import com.nanwe.push.dto.PushSendSearchCondition;
import com.nanwe.push.dto.PushSendSummaryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PushSendMapper {

    List<PushSendSummaryDto> searchPushSendList(
            @Param("cond")PushSendSearchCondition cond,
            @Param("offset") int offset,
            @Param("limit") int limit
            );

    int countPushSendList(@Param("cond") PushSendSearchCondition cond);

}
