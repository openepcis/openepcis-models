package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.PackagingMaterialTypeCode;

public interface PackagingMaterialDetails {
    QuantitativeValue getPackagingMaterialCompositionQuantity();

    void setPackagingMaterialCompositionQuantity(QuantitativeValue value);

    QuantitativeValue getPackagingMaterialThickness();

    void setPackagingMaterialThickness(QuantitativeValue value);

    PackagingMaterialTypeCode getPackagingMaterialType();

    void setPackagingMaterialType(PackagingMaterialTypeCode value);
}
