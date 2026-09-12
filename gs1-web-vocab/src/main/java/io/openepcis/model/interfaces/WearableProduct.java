/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
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
