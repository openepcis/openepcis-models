package io.openepcis.model.interfaces;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface PriceSpecification<Q extends QuantitativeValue> {
  float getDutyFeeTaxAmount();

  void setDutyFeeTaxAmount(float value);

  LinkedHashMap<String, String> getDutyFeeTaxDescription();

  void setDutyFeeTaxDescription(LinkedHashMap<String, String> value);

  float getDutyFeeTaxRate();

  void setDutyFeeTaxRate(float value);

  Q getEligibleQuantity();

  void setEligibleQuantity(Q value);

  Q getEligibleQuantityMaximum();

  void setEligibleQuantityMaximum(Q value);

  Q getEligibleQuantityMinimum();

  void setEligibleQuantityMinimum(Q value);

  float getMaxPrice();

  void setMaxPrice(float value);

  float getMinPrice();

  void setMinPrice(float value);

  float getPrice();

  void setPrice(float value);

  String getPriceCurrency();

  void setPriceCurrency(String value);

  LocalDateTime getValidFrom();

  void setValidFrom(LocalDateTime value);

  LocalDateTime getValidThrough();

  void setValidThrough(LocalDateTime value);
}
