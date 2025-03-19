package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.PackagingMaterialTypeCode;

public interface PackagingMaterialDetails<QV extends QuantitativeValue> {
  QV getPackagingMaterialCompositionQuantity();

  void setPackagingMaterialCompositionQuantity(QV value);

  QV getPackagingMaterialThickness();

  void setPackagingMaterialThickness(QV value);

  PackagingMaterialTypeCode getPackagingMaterialType();

  void setPackagingMaterialType(PackagingMaterialTypeCode value);
}
