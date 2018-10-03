package com.meesho.notification.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meesho.notification.dto.NotificationTemplateDto;
import com.meesho.notification.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/meesho/notification/admin/")
public class NotificationAdminController {

    @Autowired
    private NotificationService notificationService;

    /**
     * TODO - Admin Authorisation & Authentication here
     * @param notificationTemplateDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity createNotificationTemplate(
        @RequestBody NotificationTemplateDto notificationTemplateDto)
        throws JsonProcessingException {
        return notificationService.createTemplate(notificationTemplateDto);
    }
}
