package com.meesho.notification.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meesho.notification.converter.NotificationTemplateDtoToEntityConverter;
import com.meesho.notification.converter.NotificationTemplateToDtoConverter;
import com.meesho.notification.dto.NotificationDto;
import com.meesho.notification.dto.NotificationTemplateDto;
import com.meesho.notification.entity.NotificationTemplate;
import com.meesho.notification.repository.NotificationTemplateRepository;
import com.meesho.notification.service.INotificationService;
import com.meesho.notification.utils.NotificationUtils;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for creating notification templates
 * as well as delivering final notifications
 */
@Service
public class NotificationService implements INotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationTemplateRepository notificationTemplateRepository;

    @Autowired
    private NotificationTemplateToDtoConverter notificationTemplateToDtoConverter;

    @Autowired
    private NotificationTemplateDtoToEntityConverter notificationTemplateDtoToEntityConverter;

    /**
     * Stores a template in database
     * @param notificationTemplateDto
     */
    public void createTemplate(@Valid @NotNull NotificationTemplateDto notificationTemplateDto)
        throws JsonProcessingException {
        logger.info("Creating new notification template");
        if (logger.isDebugEnabled()){
            NotificationUtils.OBJECT_MAPPER.writeValueAsString(notificationTemplateDto);
        }
        notificationTemplateRepository.save(
            notificationTemplateDtoToEntityConverter.convert(notificationTemplateDto));
    }

    /**
     * Emits notification to corresponding channels
     * @param notificationDto
     */
    public void sendNotification(@NotNull @Valid NotificationDto notificationDto){
        Optional<NotificationTemplate> optionalNotificationTemplate =
            notificationTemplateRepository.findById(notificationDto.getTemplateId());
        if (optionalNotificationTemplate.isPresent()) {
            // TODO - Generate content from notificationTemplate & metadata
        } else {
            logger.error(
                "Error while sending notification, NotificationTemplate was found null for id ",
                notificationDto.getTemplateId());
        }
    }

    public NotificationTemplateDto getNotificationTemplateDtoByTemplateId(
        @NotBlank String templateId) {
        Optional<NotificationTemplate> notificationTemplate =
            notificationTemplateRepository.findById(templateId);
        if (notificationTemplate.isPresent()) {
            return notificationTemplateToDtoConverter.convert(notificationTemplate.get());
        } else {
            logger.error("Null notification template found for id", templateId);
            return null;
        }
    }
}