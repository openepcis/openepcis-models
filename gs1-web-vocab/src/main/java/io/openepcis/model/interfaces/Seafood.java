package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.FreshOrSeawaterFarmedCode;

public interface Seafood {
    String getCatchZone();

    void setCatchZone(String value);

    String getFishType();

    void setFishType(String value);

    FreshOrSeawaterFarmedCode getFreshOrSeawaterFarmed();

    void setFreshOrSeawaterFarmed(FreshOrSeawaterFarmedCode value);

    QuantitativeValue getMinimumFishContent();

    void setMinimumFishContent(QuantitativeValue value);
}
