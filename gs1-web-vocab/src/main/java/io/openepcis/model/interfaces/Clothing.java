package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

import java.util.LinkedHashMap;
import java.util.List;

public interface Clothing<TM extends TextileMaterialDetails> {
    LinkedHashMap<String, String> getClothingCut();

    void setClothingCut(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getCollarType();

    void setCollarType(LinkedHashMap<String, String> value);

    NonbinaryLogicCode getIsMaternity();

    void setIsMaternity(NonbinaryLogicCode value);

    List<TM> getTextileMaterial();

    void setTextileMaterial(List<TM> value);
}
