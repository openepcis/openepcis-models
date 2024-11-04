package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.StatusType;

public interface OrganizationStatusHistory {
    StatusType getOrganizationStatus();

    void setOrganizationStatus(StatusType value);

    String getStatusTimestamp();

    void setStatusTimestamp(String value);
}
