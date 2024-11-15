package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.PriceSpecificationXMLImpl;

public interface ReturnablePackageDepositDetails<P extends PriceSpecification,C extends Country> {
    P getReturnablePackageDepositAmount();

    void setReturnablePackageDepositAmount(P value);

    C getReturnablePackageDepositRegion();

    void setReturnablePackageDepositRegion(C value);
}
