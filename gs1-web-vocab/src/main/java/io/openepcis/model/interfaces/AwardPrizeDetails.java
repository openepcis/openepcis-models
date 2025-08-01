package io.openepcis.model.interfaces;

import java.time.Year;
import java.util.LinkedHashMap;

public interface AwardPrizeDetails<C extends Country> {
    String getAwardPrizeCode();

    void setAwardPrizeCode(String value);

    C getAwardPrizeCountryCode();

    void setAwardPrizeCountryCode(C value);

    LinkedHashMap<String, String> getAwardPrizeDescription();

    void setAwardPrizeDescription(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAwardPrizeJury();

    void setAwardPrizeJury(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAwardPrizeName();

    void setAwardPrizeName(LinkedHashMap<String, String> value);

    Year getAwardPrizeYear();

    void setAwardPrizeYear(Year value);
}
