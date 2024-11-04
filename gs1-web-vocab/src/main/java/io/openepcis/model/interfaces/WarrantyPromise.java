package io.openepcis.model.interfaces;

public interface WarrantyPromise {
    QuantitativeValue getDurationOfWarranty();

    void setDurationOfWarranty(QuantitativeValue value);

    String getWarrantyScopeDescription();

    void setWarrantyScopeDescription(String value);
}
