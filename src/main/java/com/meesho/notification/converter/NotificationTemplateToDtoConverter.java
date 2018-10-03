package com.meesho.notification.converter;

import com.meesho.notification.dto.NotificationTemplateDto;
import com.meesho.notification.entity.NotificationTemplate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotificationTemplateToDtoConverter implements Converter<NotificationTemplate, NotificationTemplateDto> {

    @Override
    public NotificationTemplateDto convert(NotificationTemplate notificationTemplate) {
        return NotificationTemplateDto.Builder.notificationTemplateDto()
            .withCreatedBy(notificationTemplate.getCreatedBy())
            .withLastModifiedBy(notificationTemplate.getLastModifiedBy())
            .withDateCreated(notificationTemplate.getDateCreated())
            .withLastModified(notificationTemplate.getLastModified())
            .withRequestId(notificationTemplate.getRequestId())
            .withTemplateId(notificationTemplate.getTemplateId())
            .withTemplateContentMap(notificationTemplate.getTemplateContentMap())
            .withDirectRecipients(notificationTemplate.getDirectRecipients())
            .withCcRecipients(notificationTemplate.getCcRecipients())
            .build();
    }
}
