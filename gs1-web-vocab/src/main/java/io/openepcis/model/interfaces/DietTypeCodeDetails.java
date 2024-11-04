package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.DietTypeCode;

public interface DietTypeCodeDetails {
    DietTypeCode getDietType();

    void setDietType(DietTypeCode value);

    String getDietTypeSubcode();

    void setDietTypeSubcode(String value);
}
