package com.nanwe.push.repository;

import com.nanwe.push.entity.PushApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushAppRepository extends JpaRepository<PushApp, String> {
}
