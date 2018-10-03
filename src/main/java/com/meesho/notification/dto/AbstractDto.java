package com.meesho.notification.dto;

public abstract class AbstractDto {
    public String createdBy;
    public String lastModifiedBy;
    public Long dateCreated;
    public Long lastModified;
    public String requestId;

    public AbstractDto() {
    }

    public AbstractDto(String createdBy, String lastModifiedBy, Long dateCreated,
        Long lastModified, String requestId) {
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.requestId = requestId;
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
