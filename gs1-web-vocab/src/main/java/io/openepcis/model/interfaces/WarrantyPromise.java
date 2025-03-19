package io.openepcis.model.interfaces;

public interface WarrantyPromise<QV extends QuantitativeValue> {
  QV getDurationOfWarranty();

  void setDurationOfWarranty(QV value);

  String getWarrantyScopeDescription();

  void setWarrantyScopeDescription(String value);
}
