package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.FreshOrSeawaterFarmedCode;

public interface Seafood<QV extends QuantitativeValue> {
    String getCatchZone();

    void setCatchZone(String value);

    String getFishType();

    void setFishType(String value);

    FreshOrSeawaterFarmedCode getFreshOrSeawaterFarmed();

    void setFreshOrSeawaterFarmed(FreshOrSeawaterFarmedCode value);

    QV getMinimumFishContent();

    void setMinimumFishContent(QV value);
}
