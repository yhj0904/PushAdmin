package com.nanwe.push.repository;

import com.nanwe.push.entity.PushSend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PushSendRepository extends JpaRepository<PushSend, Long> {
    Page<PushSend> findByAppIdOrderByNoticeNoDesc(String appId, Pageable pageable);
    Optional<PushSend> findByAppIdAndNoticeNo(String appId, Long noticeNo);

}
