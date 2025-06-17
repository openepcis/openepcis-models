package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.LevelOfContainmentCode;

import java.util.LinkedHashMap;

public interface AdditiveDetails{
    LevelOfContainmentCode getAdditiveLevelOfContainment();

    void setAdditiveLevelOfContainment(LevelOfContainmentCode value);

    LinkedHashMap<String, String> getAdditiveName();

    void setAdditiveName(LinkedHashMap<String, String> value);
}
