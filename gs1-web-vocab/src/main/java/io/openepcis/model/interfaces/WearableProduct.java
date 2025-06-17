package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

import java.time.Year;
import java.util.LinkedHashMap;
import java.util.List;

public interface WearableProduct<SD extends SizeDetails> {
    ConsumerLifestageCode getConsumerLifestage();

    void setConsumerLifestage(ConsumerLifestageCode value);

    NonbinaryLogicCode getIsPatterned();

    void setIsPatterned(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsThermal();

    void setIsThermal(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsWaterproof();

    void setIsWaterproof(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsWearableItemDisposable();

    void setIsWearableItemDisposable(NonbinaryLogicCode value);

    Year getSeasonCalendarYear();

    void setSeasonCalendarYear(Year value);

    LinkedHashMap<String, String> getSeasonName();

    void setSeasonName(LinkedHashMap<String, String> value);

    SeasonParameterCode getSeasonParameter();

    void setSeasonParameter(SeasonParameterCode value);

    List<SD> getSize();

    void setSize(List<SD> value);

    SportingActivityTypeCode getSportingActivityType();

    void setSportingActivityType(SportingActivityTypeCode value);

    LinkedHashMap<String, String> getStyleDescription();

    void setStyleDescription(LinkedHashMap<String, String> value);

    String getTargetConsumerAge();

    void setTargetConsumerAge(String value);

    TargetConsumerGenderCode getTargetConsumerGender();

    void setTargetConsumerGender(TargetConsumerGenderCode value);

    LinkedHashMap<String, String> getTextileMaterialContent();

    void setTextileMaterialContent(LinkedHashMap<String, String> value);
}
