package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CheeseFirmnessCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;
import io.openepcis.model.gs1webvocab.SharpnessOfCheeseCode;

public interface MilkButterCreamYogurtCheeseEggsSubstitutes extends FoodBeverageTobaccoProduct {
    CheeseFirmnessCode getCheeseFirmness();

    void setCheeseFirmness(CheeseFirmnessCode value);

    String getCheeseMaturationPeriodDescription();

    void setCheeseMaturationPeriodDescription(String value);

    String getFatInMilkContent();

    void setFatInMilkContent(String value);

    String getFatpercentageInDryMatter();

    void setFatpercentageInDryMatter(String value);

    NonbinaryLogicCode getIsHomogenised();

    void setIsHomogenised(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsRindEdible();

    void setIsRindEdible(NonbinaryLogicCode value);

    SharpnessOfCheeseCode getSharpnessOfCheese();

    void setSharpnessOfCheese(SharpnessOfCheeseCode value);
}
