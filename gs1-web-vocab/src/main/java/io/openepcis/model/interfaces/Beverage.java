package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

public interface Beverage {
    String getAlcoholicBeverageSubregion();

    void setAlcoholicBeverageSubregion(String value);

    String getBeverageVintage();

    void setBeverageVintage(String value);

    NonbinaryLogicCode getIsCarbonated();

    void setIsCarbonated(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsDecaffeinated();

    void setIsDecaffeinated(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsFromConcentrate();

    void setIsFromConcentrate(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsVintage();

    void setIsVintage(NonbinaryLogicCode value);

    String getPercentageOfAlcoholByVolume();

    void setPercentageOfAlcoholByVolume(String value);

    String getVintner();

    void setVintner(String value);
}
