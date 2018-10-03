package com.meesho.notification.dto;

import com.meesho.notification.enums.NotificationChannel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

public class NotificationTemplateDto extends AbstractDto{

    @ApiModelProperty(value = "Unique identifier of this entity, will be null in case of object creation")
    private String templateId;

    @ApiModelProperty(value = "Raw subect & body of notificaton template corresponding to notification channel")
    private Map<NotificationChannel, Pair<String,String>> templateContentMap;

    @ApiModelProperty(value = "directRecipients")
    private Set<String> directRecipients;

    @ApiModelProperty(value = "ccRecipients")
    private Set<String> ccRecipients;

    public NotificationTemplateDto() {
    }

    public NotificationTemplateDto(String createdBy, String lastModifiedBy, Long dateCreated,
        Long lastModified, String requestId, String templateId,
        Map<NotificationChannel, Pair<String, String>> templateContentMap,
        Set<String> directRecipients, Set<String> ccRecipients) {
        super(createdBy, lastModifiedBy, dateCreated, lastModified, requestId);
        this.templateId = templateId;
        this.templateContentMap = templateContentMap;
        this.directRecipients = directRecipients;
        this.ccRecipients = ccRecipients;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<NotificationChannel, Pair<String, String>> getTemplateContentMap() {
        return templateContentMap;
    }

    public void setTemplateContentMap(
        Map<NotificationChannel, Pair<String, String>> templateContentMap) {
        this.templateContentMap = templateContentMap;
    }

    public Set<String> getDirectRecipients() {
        return directRecipients;
    }

    public void setDirectRecipients(Set<String> directRecipients) {
        this.directRecipients = directRecipients;
    }

    public Set<String> getCcRecipients() {
        return ccRecipients;
    }

    public void setCcRecipients(Set<String> ccRecipients) {
        this.ccRecipients = ccRecipients;
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
        TemplateContentMapStep withTemplateId(String templateId);
    }

    public static interface TemplateContentMapStep {
        DirectRecipientsStep withTemplateContentMap(
            Map<NotificationChannel, Pair<String, String>> templateContentMap);
    }

    public static interface DirectRecipientsStep {
        CcRecipientsStep withDirectRecipients(Set<String> directRecipients);
    }

    public static interface CcRecipientsStep {
        BuildStep withCcRecipients(Set<String> ccRecipients);
    }

    public static interface BuildStep {
        NotificationTemplateDto build();
    }

    public static class Builder
        implements CreatedByStep, LastModifiedByStep, DateCreatedStep, LastModifiedStep,
        RequestIdStep, TemplateIdStep, TemplateContentMapStep, DirectRecipientsStep,
        CcRecipientsStep, BuildStep {
        private String createdBy;

        private String lastModifiedBy;

        private Long dateCreated;

        private Long lastModified;

        private String requestId;

        private String templateId;

        private Map<NotificationChannel, Pair<String, String>> templateContentMap;

        private Set<String> directRecipients;

        private Set<String> ccRecipients;

        private Builder() {
        }

        public static CreatedByStep notificationTemplateDto() {
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
        public TemplateContentMapStep withTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        @Override
        public DirectRecipientsStep withTemplateContentMap(
            Map<NotificationChannel, Pair<String, String>> templateContentMap) {
            this.templateContentMap = templateContentMap;
            return this;
        }

        @Override
        public CcRecipientsStep withDirectRecipients(Set<String> directRecipients) {
            this.directRecipients = directRecipients;
            return this;
        }

        @Override
        public BuildStep withCcRecipients(Set<String> ccRecipients) {
            this.ccRecipients = ccRecipients;
            return this;
        }

        @Override
        public NotificationTemplateDto build() {
            return new NotificationTemplateDto(
                this.createdBy,
                this.lastModifiedBy,
                this.dateCreated,
                this.lastModified,
                this.requestId,
                this.templateId,
                this.templateContentMap,
                this.directRecipients,
                this.ccRecipients
            );
        }
    }
}
