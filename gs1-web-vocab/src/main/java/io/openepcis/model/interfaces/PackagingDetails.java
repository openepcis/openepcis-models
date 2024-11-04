package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface PackagingDetails {
    ReturnablePackageDepositDetails getHasReturnablePackageDeposit();

    void setHasReturnablePackageDeposit(ReturnablePackageDepositDetails value);

    PackagingFeatureCode getPackagingFeature();

    void setPackagingFeature(PackagingFeatureCode value);

    PackagingFunctionCode getPackagingFunction();

    void setPackagingFunction(PackagingFunctionCode value);

    PackagingMaterialDetails getPackagingMaterial();

    void setPackagingMaterial(PackagingMaterialDetails value);

    PackagingRecyclingProcessTypeCode getPackagingRecyclingProcessType();

    void setPackagingRecyclingProcessType(PackagingRecyclingProcessTypeCode value);

    PackagingRecyclingSchemeCode getPackagingRecyclingScheme();

    void setPackagingRecyclingScheme(PackagingRecyclingSchemeCode value);

    PackagingShapeCode getPackagingShape();

    void setPackagingShape(PackagingShapeCode value);

    String getPackagingType();

    void setPackagingType(String value);
}
