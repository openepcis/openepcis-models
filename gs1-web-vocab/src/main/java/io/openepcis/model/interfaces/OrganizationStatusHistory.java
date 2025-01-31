package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.StatusType;

import java.time.LocalDateTime;

public interface OrganizationStatusHistory {
    StatusType getOrganizationStatus();

    void setOrganizationStatus(StatusType value);

    LocalDateTime getStatusTimestamp();

    void setStatusTimestamp(LocalDateTime value);
}
