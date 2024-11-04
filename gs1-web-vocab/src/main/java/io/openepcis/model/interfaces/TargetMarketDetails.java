package io.openepcis.model.interfaces;

public interface TargetMarketDetails {
    String getConsumerFirstAvailabilityDateTime();

    void setConsumerFirstAvailabilityDateTime(String value);

    Country getTargetMarketCountries();

    void setTargetMarketCountries(Country value);
}
