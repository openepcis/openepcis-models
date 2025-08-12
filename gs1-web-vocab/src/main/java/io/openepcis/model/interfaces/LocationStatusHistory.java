package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.StatusType;

import java.time.LocalDateTime;

public interface LocationStatusHistory {
  StatusType getLocationStatus();

  void setLocationStatus(StatusType value);

  LocalDateTime getStatusTimestamp();

  void setStatusTimestamp(LocalDateTime value);
}
