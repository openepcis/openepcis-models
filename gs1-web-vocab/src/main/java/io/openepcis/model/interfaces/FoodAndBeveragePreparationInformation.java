package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.PreparationTypeCode;

public interface FoodAndBeveragePreparationInformation {
    String getConvenienceLevelPercent();

    void setConvenienceLevelPercent(String value);

    PreparationTypeCode getManufacturerPreparationCode();

    void setManufacturerPreparationCode(PreparationTypeCode value);

    QuantitativeValue getMaximumOptimumConsumptionTemperature();

    void setMaximumOptimumConsumptionTemperature(QuantitativeValue value);

    QuantitativeValue getMinimumOptimumConsumptionTemperature();

    void setMinimumOptimumConsumptionTemperature(QuantitativeValue value);

    PreparationTypeCode getPreparationCode();

    void setPreparationCode(PreparationTypeCode value);

    String getPreparationConsumptionPrecautions();

    void setPreparationConsumptionPrecautions(String value);

    String getPreparationInstructions();

    void setPreparationInstructions(String value);

    ProductYieldDetails getYield();

    void setYield(ProductYieldDetails value);
}
