package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;
import java.util.List;

public interface Clothing<TM extends TextileMaterialDetails> {
  String getClothingCut();

  void setClothingCut(String value);

  String getCollarType();

  void setCollarType(String value);

  NonbinaryLogicCode getIsMaternity();

  void setIsMaternity(NonbinaryLogicCode value);

  List<TM> getTextileMaterial();

  void setTextileMaterial(List<TM> value);
}
