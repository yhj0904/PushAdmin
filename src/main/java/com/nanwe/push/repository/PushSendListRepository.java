package com.nanwe.push.repository;

import com.nanwe.push.entity.PushSendList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PushSendListRepository extends JpaRepository<PushSendList, Long> {
    List<PushSendList> findByAppIdAndNoticeNo(String appId, Long noticeNo);

}
