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

import io.openepcis.model.gs1webvocab.PreparationTypeCode;

import java.util.LinkedHashMap;
import java.util.List;

public interface FoodAndBeveragePreparationInformation<PY extends ProductYieldDetails, QV extends QuantitativeValue> {
    float getConvenienceLevelPercent();

    void setConvenienceLevelPercent(float value);

    PreparationTypeCode getManufacturerPreparationCode();

    void setManufacturerPreparationCode(PreparationTypeCode value);

    QV getMaximumOptimumConsumptionTemperature();

    void setMaximumOptimumConsumptionTemperature(QV value);

    QV getMinimumOptimumConsumptionTemperature();

    void setMinimumOptimumConsumptionTemperature(QV value);

    PreparationTypeCode getPreparationCode();

    void setPreparationCode(PreparationTypeCode value);

    LinkedHashMap<String, String> getPreparationConsumptionPrecautions();

    void setPreparationConsumptionPrecautions(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getPreparationInstructions();

    void setPreparationInstructions(LinkedHashMap<String, String> value);

    List<PY> getYield();

    void setYield(List<PY> value);
}
