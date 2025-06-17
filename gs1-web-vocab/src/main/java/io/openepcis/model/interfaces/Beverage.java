package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

import java.util.LinkedHashMap;

public interface Beverage {
    LinkedHashMap<String, String> getAlcoholicBeverageSubregion();

    void setAlcoholicBeverageSubregion(LinkedHashMap<String, String> value);

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

    float getPercentageOfAlcoholByVolume();

    void setPercentageOfAlcoholByVolume(float value);

    LinkedHashMap<String, String> getVintner();

    void setVintner(LinkedHashMap<String, String> value);
}
