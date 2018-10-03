package com.meesho.notification.dto;

import com.meesho.notification.enums.NotificationChannel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.Set;
import javax.validation.constraints.NotNull;

public class NotificationDto extends AbstractDto {

    @NotNull
    @ApiModelProperty(notes = "Unique identifier of notificationTemplate for which this notification is to be sent")
    private String templateId;

    /**
     * this metadata will be used in conjunction with template body & subject
     * to create final data to be sent to user
     */
    @ApiModelProperty(notes = "Variable parameters to be merged with template body & content to create final message")
    private Map<String, String> metadata;

    // Ex. ORDER_PROCESSING
    @NotNull
    private String entity;

    // Ex. NEW_ORDER_CUSTOMER_NOTIFICATION
    @NotNull
    private String event;

    /**
     * This needs to be a subset of channels defined in Template
     */
    @ApiModelProperty(notes = "Channels for which this notification is to be sent")
    private Set<NotificationChannel> notificationChannels;

    public NotificationDto() {
    }

    public NotificationDto(String createdBy, String lastModifiedBy, Long dateCreated,
        Long lastModified, String requestId,
        @NotNull String templateId, Map<String, String> metadata,
        @NotNull String entity, @NotNull String event,
        Set<NotificationChannel> notificationChannels) {
        super(createdBy, lastModifiedBy, dateCreated, lastModified, requestId);
        this.templateId = templateId;
        this.metadata = metadata;
        this.entity = entity;
        this.event = event;
        this.notificationChannels = notificationChannels;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Set<NotificationChannel> getNotificationChannels() {
        return notificationChannels;
    }

    public void setNotificationChannels(
        Set<NotificationChannel> notificationChannels) {
        this.notificationChannels = notificationChannels;
    }

    public static interface CreatedByStep {
        LastModifiedByStep withCreatedBy(String createdBy);
    }

    public static interface LastModifiedByStep {
        DateCreatedStep withLastModifiedBy(String lastModifiedBy);
    }

    public static interface DateCreatedStep {
        LastModifiedStep withDateCreated(Long dateCreated);
    }

    public static interface LastModifiedStep {
        RequestIdStep withLastModified(Long lastModified);
    }

    public static interface RequestIdStep {
        TemplateIdStep withRequestId(String requestId);
    }

    public static interface TemplateIdStep {
        MetadataStep withTemplateId(String templateId);
    }

    public static interface MetadataStep {
        EntityStep withMetadata(Map<String, String> metadata);
    }

    public static interface EntityStep {
        EventStep withEntity(String entity);
    }

    public static interface EventStep {
        NotificationChannelsStep withEvent(String event);
    }

    public static interface NotificationChannelsStep {
        BuildStep withNotificationChannels(Set<NotificationChannel> notificationChannels);
    }

    public static interface BuildStep {
        NotificationDto build();
    }

    public static class Builder
        implements CreatedByStep, LastModifiedByStep, DateCreatedStep, LastModifiedStep,
        RequestIdStep, TemplateIdStep, MetadataStep, EntityStep, EventStep,
        NotificationChannelsStep, BuildStep {
        private String createdBy;

        private String lastModifiedBy;

        private Long dateCreated;

        private Long lastModified;

        private String requestId;

        private String templateId;

        private Map<String, String> metadata;

        private String entity;

        private String event;

        private Set<NotificationChannel> notificationChannels;

        private Builder() {
        }

        public static CreatedByStep notificationDto() {
            return new Builder();
        }

        @Override
        public LastModifiedByStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public DateCreatedStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        public LastModifiedStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public RequestIdStep withLastModified(Long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public TemplateIdStep withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public MetadataStep withTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        @Override
        public EntityStep withMetadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        @Override
        public EventStep withEntity(String entity) {
            this.entity = entity;
            return this;
        }

        @Override
        public NotificationChannelsStep withEvent(String event) {
            this.event = event;
            return this;
        }

        @Override
        public BuildStep withNotificationChannels(Set<NotificationChannel> notificationChannels) {
            this.notificationChannels = notificationChannels;
            return this;
        }

        @Override
        public NotificationDto build() {
            return new NotificationDto(
                this.createdBy,
                this.lastModifiedBy,
                this.dateCreated,
                this.lastModified,
                this.requestId,
                this.templateId,
                this.metadata,
                this.entity,
                this.event,
                this.notificationChannels
            );
        }
    }
}
