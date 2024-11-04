package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.ProductYieldTypeCode;

public interface ProductYieldDetails {
    QuantitativeValue getProductYield();

    void setProductYield(QuantitativeValue value);

    ProductYieldTypeCode getProductYieldType();

    void setProductYieldType(ProductYieldTypeCode value);

    String getProductYieldVariationPercentage();

    void setProductYieldVariationPercentage(String value);
}
