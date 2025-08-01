package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.AnatomicalFormCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

import java.util.LinkedHashMap;

public interface MeatPoultry<QV extends QuantitativeValue> {
    AnatomicalFormCode getAnatomicalForm();

    void setAnatomicalForm(AnatomicalFormCode value);

    NonbinaryLogicCode getBonelessClaim();

    void setBonelessClaim(NonbinaryLogicCode value);

    LinkedHashMap<String, String> getMeatPoultryType();

    void setMeatPoultryType(LinkedHashMap<String, String> value);

    QV getMinimumMeatPoultryContent();

    void setMinimumMeatPoultryContent(QV value);
}
