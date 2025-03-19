package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CheeseFirmnessCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;
import io.openepcis.model.gs1webvocab.SharpnessOfCheeseCode;

public interface MilkButterCreamYogurtCheeseEggsSubstitutes {
  CheeseFirmnessCode getCheeseFirmness();

  void setCheeseFirmness(CheeseFirmnessCode value);

  String getCheeseMaturationPeriodDescription();

  void setCheeseMaturationPeriodDescription(String value);

  float getFatInMilkContent();

  void setFatInMilkContent(float value);

  float getFatpercentageInDryMatter();

  void setFatpercentageInDryMatter(float value);

  NonbinaryLogicCode getIsHomogenised();

  void setIsHomogenised(NonbinaryLogicCode value);

  NonbinaryLogicCode getIsRindEdible();

  void setIsRindEdible(NonbinaryLogicCode value);

  SharpnessOfCheeseCode getSharpnessOfCheese();

  void setSharpnessOfCheese(SharpnessOfCheeseCode value);
}
