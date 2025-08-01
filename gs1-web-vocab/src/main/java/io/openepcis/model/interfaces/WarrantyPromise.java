package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface WarrantyPromise<QV extends QuantitativeValue> {
  QV getDurationOfWarranty();

  void setDurationOfWarranty(QV value);

  LinkedHashMap<String, String> getWarrantyScopeDescription();

  void setWarrantyScopeDescription(LinkedHashMap<String, String> value);
}
