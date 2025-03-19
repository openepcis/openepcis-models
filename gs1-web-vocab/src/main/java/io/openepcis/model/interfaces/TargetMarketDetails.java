package io.openepcis.model.interfaces;

import java.time.LocalDateTime;

public interface TargetMarketDetails<C extends Country> {
  LocalDateTime getConsumerFirstAvailabilityDateTime();

  void setConsumerFirstAvailabilityDateTime(LocalDateTime value);

  C getTargetMarketCountries();

  void setTargetMarketCountries(C value);
}
