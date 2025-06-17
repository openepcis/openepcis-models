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
