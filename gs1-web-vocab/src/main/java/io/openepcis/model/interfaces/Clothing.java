package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

public interface Clothing<TM extends TextileMaterialDetails> {
    String getClothingCut();

    void setClothingCut(String value);

    String getCollarType();

    void setCollarType(String value);

    NonbinaryLogicCode getIsMaternity();

    void setIsMaternity(NonbinaryLogicCode value);

    TM getTextileMaterial();

    void setTextileMaterial(TM value);
}
