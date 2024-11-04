package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

public interface Clothing {
    String getClothingCut();

    void setClothingCut(String value);

    String getCollarType();

    void setCollarType(String value);

    NonbinaryLogicCode getIsMaternity();

    void setIsMaternity(NonbinaryLogicCode value);

    TextileMaterialDetails getTextileMaterial();

    void setTextileMaterial(TextileMaterialDetails value);
}
