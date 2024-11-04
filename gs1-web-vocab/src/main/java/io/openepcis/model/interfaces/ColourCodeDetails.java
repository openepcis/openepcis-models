package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.ColourCodeListCode;

public interface ColourCodeDetails {
    ColourCodeListCode getColourCodeList();

    void setColourCodeList(ColourCodeListCode value);

    String getColourCodeValue();

    void setColourCodeValue(String value);
}
