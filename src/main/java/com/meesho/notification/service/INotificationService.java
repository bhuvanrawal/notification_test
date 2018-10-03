package com.meesho.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meesho.notification.dto.NotificationDto;
import com.meesho.notification.dto.NotificationTemplateDto;

public interface INotificationService {

    /**
     * Creates a notification template in the database to be looked up further
     */
    void createTemplate(NotificationTemplateDto notificationTemplateDto)
        throws JsonProcessingException;

    /**
     *
     */
    void sendNotification(NotificationDto notificationDto);

    NotificationTemplateDto getNotificationTemplateDtoByTemplateId(String templateId);

}