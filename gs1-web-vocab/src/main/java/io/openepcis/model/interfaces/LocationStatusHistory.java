package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.StatusType;

public interface LocationStatusHistory {
    StatusType getLocationStatus();

    void setLocationStatus(StatusType value);

    String getStatusTimestamp();

    void setStatusTimestamp(String value);
}
