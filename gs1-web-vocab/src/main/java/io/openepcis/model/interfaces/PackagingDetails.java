package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;
import java.util.List;

public interface PackagingDetails<
    RPD extends ReturnablePackageDepositDetails, PM extends PackagingMaterialDetails> {
  List<RPD> getHasReturnablePackageDeposit();

  void setHasReturnablePackageDeposit(List<RPD> value);

  PackagingFeatureCode getPackagingFeature();

  void setPackagingFeature(PackagingFeatureCode value);

  PackagingFunctionCode getPackagingFunction();

  void setPackagingFunction(PackagingFunctionCode value);

  List<PM> getPackagingMaterial();

  void setPackagingMaterial(List<PM> value);

  PackagingRecyclingProcessTypeCode getPackagingRecyclingProcessType();

  void setPackagingRecyclingProcessType(PackagingRecyclingProcessTypeCode value);

  PackagingRecyclingSchemeCode getPackagingRecyclingScheme();

  void setPackagingRecyclingScheme(PackagingRecyclingSchemeCode value);

  PackagingShapeCode getPackagingShape();

  void setPackagingShape(PackagingShapeCode value);

  String getPackagingType();

  void setPackagingType(String value);
}
