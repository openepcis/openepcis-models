package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface PackagingDetails<RPD extends ReturnablePackageDepositDetails, PM extends PackagingMaterialDetails> {
    RPD getHasReturnablePackageDeposit();

    void setHasReturnablePackageDeposit(RPD value);

    PackagingFeatureCode getPackagingFeature();

    void setPackagingFeature(PackagingFeatureCode value);

    PackagingFunctionCode getPackagingFunction();

    void setPackagingFunction(PackagingFunctionCode value);

    PM getPackagingMaterial();

    void setPackagingMaterial(PM value);

    PackagingRecyclingProcessTypeCode getPackagingRecyclingProcessType();

    void setPackagingRecyclingProcessType(PackagingRecyclingProcessTypeCode value);

    PackagingRecyclingSchemeCode getPackagingRecyclingScheme();

    void setPackagingRecyclingScheme(PackagingRecyclingSchemeCode value);

    PackagingShapeCode getPackagingShape();

    void setPackagingShape(PackagingShapeCode value);

    String getPackagingType();

    void setPackagingType(String value);
}
