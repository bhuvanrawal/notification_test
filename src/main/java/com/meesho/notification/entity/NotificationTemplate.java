package com.meesho.notification.entity;

import com.meesho.notification.enums.NotificationChannel;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonStringType.class),
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity(name = "notificationTemplate")
public class NotificationTemplate extends AbstractEntity{

    @Column(name = "templateId")
    private String templateId;

    @Type(type = "json")
    @Column(name = "templateContentMap", columnDefinition = "json", nullable = false)
    private Map<NotificationChannel, Pair<String,String>> templateContentMap;

    @Type(type = "json")
    @Column(name = "directRecipients", columnDefinition = "json", nullable = true)
    private Set<String> directRecipients;

    @Type(type = "json")
    @Column(name = "ccRecipients", columnDefinition = "json", nullable = true)
    private Set<String> ccRecipients;

    public NotificationTemplate() {
    }

    public NotificationTemplate(Long dateCreated, Long lastModified, String createdBy,
        String lastModifiedBy, String requestId, String templateId,
        Map<NotificationChannel, Pair<String, String>> templateContentMap,
        Set<String> directRecipients, Set<String> ccRecipients) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, requestId);
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

    public static interface DateCreatedStep {
        LastModifiedStep withDateCreated(Long dateCreated);
    }

    public static interface LastModifiedStep {
        CreatedByStep withLastModified(Long lastModified);
    }

    public static interface CreatedByStep {
        LastModifiedByStep withCreatedBy(String createdBy);
    }

    public static interface LastModifiedByStep {
        RequestIdStep withLastModifiedBy(String lastModifiedBy);
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
        NotificationTemplate build();
    }

    public static class Builder
        implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep,
        RequestIdStep, TemplateIdStep, TemplateContentMapStep, DirectRecipientsStep,
        CcRecipientsStep, BuildStep {
        private Long dateCreated;

        private Long lastModified;

        private String createdBy;

        private String lastModifiedBy;

        private String requestId;

        private String templateId;

        private Map<NotificationChannel, Pair<String, String>> templateContentMap;

        private Set<String> directRecipients;

        private Set<String> ccRecipients;

        private Builder() {
        }

        public static DateCreatedStep notificationTemplate() {
            return new Builder();
        }

        @Override
        public LastModifiedStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public CreatedByStep withLastModified(Long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public LastModifiedByStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public RequestIdStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
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
        public NotificationTemplate build() {
            return new NotificationTemplate(
                this.dateCreated,
                this.lastModified,
                this.createdBy,
                this.lastModifiedBy,
                this.requestId,
                this.templateId,
                this.templateContentMap,
                this.directRecipients,
                this.ccRecipients
            );
        }
    }
}
