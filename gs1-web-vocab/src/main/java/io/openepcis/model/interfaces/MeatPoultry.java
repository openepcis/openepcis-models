package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.AnatomicalFormCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

public interface MeatPoultry<QV extends QuantitativeValue> {
    AnatomicalFormCode getAnatomicalForm();

    void setAnatomicalForm(AnatomicalFormCode value);

    NonbinaryLogicCode getBonelessClaim();

    void setBonelessClaim(NonbinaryLogicCode value);

    String getMeatPoultryType();

    void setMeatPoultryType(String value);

    QV getMinimumMeatPoultryContent();

    void setMinimumMeatPoultryContent(QV value);
}
