package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.LevelOfContainmentCode;

public interface AdditiveDetails {
    LevelOfContainmentCode getAdditiveLevelOfContainment();

    void setAdditiveLevelOfContainment(LevelOfContainmentCode value);

    String getAdditiveName();

    void setAdditiveName(String value);
}
