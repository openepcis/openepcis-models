package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.FreshOrSeawaterFarmedCode;

import java.util.LinkedHashMap;

public interface Seafood<QV extends QuantitativeValue> {
    LinkedHashMap<String, String> getCatchZone();

    void setCatchZone(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getFishType();

    void setFishType(LinkedHashMap<String, String> value);

    FreshOrSeawaterFarmedCode getFreshOrSeawaterFarmed();

    void setFreshOrSeawaterFarmed(FreshOrSeawaterFarmedCode value);

    QV getMinimumFishContent();

    void setMinimumFishContent(QV value);
}
