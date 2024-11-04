package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface WearableProduct extends Product {
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

    String getSeasonCalendarYear();

    void setSeasonCalendarYear(String value);

    String getSeasonName();

    void setSeasonName(String value);

    SeasonParameterCode getSeasonParameter();

    void setSeasonParameter(SeasonParameterCode value);

    SizeDetails getSize();

    void setSize(SizeDetails value);

    SportingActivityTypeCode getSportingActivityType();

    void setSportingActivityType(SportingActivityTypeCode value);

    String getStyleDescription();

    void setStyleDescription(String value);

    String getTargetConsumerAge();

    void setTargetConsumerAge(String value);

    TargetConsumerGenderCode getTargetConsumerGender();

    void setTargetConsumerGender(TargetConsumerGenderCode value);

    String getTextileMaterialContent();

    void setTextileMaterialContent(String value);
}
