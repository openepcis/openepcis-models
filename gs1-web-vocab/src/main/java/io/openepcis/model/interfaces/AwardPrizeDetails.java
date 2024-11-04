package io.openepcis.model.interfaces;

public interface AwardPrizeDetails {
    String getAwardPrizeCode();

    void setAwardPrizeCode(String value);

    Country getAwardPrizeCountryCode();

    void setAwardPrizeCountryCode(Country value);

    String getAwardPrizeDescription();

    void setAwardPrizeDescription(String value);

    String getAwardPrizeJury();

    void setAwardPrizeJury(String value);

    String getAwardPrizeName();

    void setAwardPrizeName(String value);

    String getAwardPrizeYear();

    void setAwardPrizeYear(String value);
}
