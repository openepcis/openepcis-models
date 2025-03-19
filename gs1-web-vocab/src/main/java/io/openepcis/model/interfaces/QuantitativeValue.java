package io.openepcis.model.interfaces;

public interface QuantitativeValue {
  String getUnitCode();

  void setUnitCode(String value);

  float getValue();

  void setValue(float value);
}
