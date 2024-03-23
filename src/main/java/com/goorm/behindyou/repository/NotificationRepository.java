package com.goorm.behindyou.repository;

import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findByKeyword(Keyword keyword);
}
