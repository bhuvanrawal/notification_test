package com.meesho.notification.converter;

import com.meesho.notification.dto.NotificationTemplateDto;
import com.meesho.notification.entity.NotificationTemplate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotificationTemplateDtoToEntityConverter implements
    Converter<NotificationTemplateDto, NotificationTemplate> {
    @Override
    public NotificationTemplate convert(NotificationTemplateDto notificationTemplateDto) {
        return NotificationTemplate.Builder.notificationTemplate()
            .withDateCreated(notificationTemplateDto.getDateCreated())
            .withLastModified(notificationTemplateDto.getLastModified())
            .withCreatedBy(notificationTemplateDto.getCreatedBy())
            .withLastModifiedBy(notificationTemplateDto.getLastModifiedBy())
            .withRequestId(notificationTemplateDto.getRequestId())
            .withTemplateId(notificationTemplateDto.getTemplateId())
            .withTemplateContentMap(notificationTemplateDto.getTemplateContentMap())
            .withDirectRecipients(notificationTemplateDto.getDirectRecipients())
            .withCcRecipients(notificationTemplateDto.getCcRecipients())
            .build();
    }
}
