package io.openepcis.model.interfaces;

public interface TargetMarketDetails<C extends Country> {
    String getConsumerFirstAvailabilityDateTime();

    void setConsumerFirstAvailabilityDateTime(String value);

    C getTargetMarketCountries();

    void setTargetMarketCountries(C value);
}
