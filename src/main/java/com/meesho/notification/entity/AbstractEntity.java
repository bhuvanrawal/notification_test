package com.meesho.notification.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateCreated", nullable = false)
    private Long dateCreated;

    @Column(name = "lastModified", nullable = false)
    private Long lastModified;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

    @Column(name = "lastModifiedBy", nullable = false)
    private String lastModifiedBy;

    @Column(name = "requestId", nullable = false)
    private String requestId;

    public AbstractEntity() {
    }

    public AbstractEntity(Long dateCreated, Long lastModified, String createdBy,
        String lastModifiedBy, String requestId) {
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.requestId = requestId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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
        BuildStep withRequestId(String requestId);
    }

    public static interface BuildStep {
        AbstractEntity build();
    }

    public static class Builder
        implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep,
        RequestIdStep, BuildStep {
        private Long dateCreated;

        private Long lastModified;

        private String createdBy;

        private String lastModifiedBy;

        private String requestId;

        private Builder() {
        }

        public static DateCreatedStep abstractEntity() {
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
        public BuildStep withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public AbstractEntity build() {
            return new AbstractEntity(
                this.dateCreated,
                this.lastModified,
                this.createdBy,
                this.lastModifiedBy,
                this.requestId
            );
        }
    }
}
