package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.ProductYieldTypeCode;

public interface ProductYieldDetails<QV extends QuantitativeValue> {
  QV getProductYield();

  void setProductYield(QV value);

  ProductYieldTypeCode getProductYieldType();

  void setProductYieldType(ProductYieldTypeCode value);

  float getProductYieldVariationPercentage();

  void setProductYieldVariationPercentage(float value);
}
