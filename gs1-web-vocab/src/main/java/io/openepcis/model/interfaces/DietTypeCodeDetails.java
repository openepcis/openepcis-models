package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.DietTypeCode;

import java.util.LinkedHashMap;

public interface DietTypeCodeDetails {
    DietTypeCode getDietType();

    void setDietType(DietTypeCode value);

    LinkedHashMap<String, String> getDietTypeSubcode();

    void setDietTypeSubcode(LinkedHashMap<String, String> value);
}
