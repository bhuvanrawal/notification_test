package com.meesho.notification.repository;

import com.meesho.notification.entity.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class NotificationTemplateRepository
    implements JpaRepository<NotificationTemplate, String> {
}
