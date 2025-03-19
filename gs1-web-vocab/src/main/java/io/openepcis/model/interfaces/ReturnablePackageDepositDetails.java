package io.openepcis.model.interfaces;

public interface ReturnablePackageDepositDetails<P extends PriceSpecification, C extends Country> {
  P getReturnablePackageDepositAmount();

  void setReturnablePackageDepositAmount(P value);

  C getReturnablePackageDepositRegion();

  void setReturnablePackageDepositRegion(C value);
}
