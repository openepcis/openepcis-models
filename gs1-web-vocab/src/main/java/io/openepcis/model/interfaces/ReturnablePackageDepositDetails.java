package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.PriceSpecificationXMLImpl;

public interface ReturnablePackageDepositDetails {
    PriceSpecificationXMLImpl getReturnablePackageDepositAmount();

    void setReturnablePackageDepositAmount(PriceSpecificationXMLImpl value);

    Country getReturnablePackageDepositRegion();

    void setReturnablePackageDepositRegion(Country value);
}
