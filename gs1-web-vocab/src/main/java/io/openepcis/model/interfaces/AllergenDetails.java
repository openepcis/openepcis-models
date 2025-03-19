package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.AllergenTypeCode;
import io.openepcis.model.gs1webvocab.LevelOfContainmentCode;

public interface AllergenDetails {
  LevelOfContainmentCode getAllergenLevelOfContainmentCode();

  void setAllergenLevelOfContainmentCode(LevelOfContainmentCode value);

  AllergenTypeCode getAllergenType();

  void setAllergenType(AllergenTypeCode value);
}
