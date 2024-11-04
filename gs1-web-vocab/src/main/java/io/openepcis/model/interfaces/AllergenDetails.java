package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.LevelOfContainmentCode;

public interface AllergenDetails {
    LevelOfContainmentCode getAllergenLevelOfContainmentCode();

    void setAllergenLevelOfContainmentCode(LevelOfContainmentCode value);

    String getAllergenType();

    void setAllergenType(String value);
}
