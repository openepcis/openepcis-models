package io.openepcis.model.interfaces;

import java.time.LocalDate;
import java.time.Year;

public interface AwardPrizeDetails<C extends Country> {
    String getAwardPrizeCode();

    void setAwardPrizeCode(String value);

    C getAwardPrizeCountryCode();

    void setAwardPrizeCountryCode(C value);

    String getAwardPrizeDescription();

    void setAwardPrizeDescription(String value);

    String getAwardPrizeJury();

    void setAwardPrizeJury(String value);

    String getAwardPrizeName();

    void setAwardPrizeName(String value);

    Year getAwardPrizeYear();

    void setAwardPrizeYear(Year value);
}
