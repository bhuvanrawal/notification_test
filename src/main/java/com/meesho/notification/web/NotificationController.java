package com.meesho.notification.web;

import com.meesho.notification.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/meesho/notification/web/")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


}