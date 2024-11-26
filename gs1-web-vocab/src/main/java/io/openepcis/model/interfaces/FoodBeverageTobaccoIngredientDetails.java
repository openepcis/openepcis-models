package io.openepcis.model.interfaces;

import java.math.BigInteger;

public interface FoodBeverageTobaccoIngredientDetails {
    String getIngredientContentPercentage();

    void setIngredientContentPercentage(String value);

    String getIngredientName();

    void setIngredientName(String value);

    BigInteger getIngredientSequence();

    void setIngredientSequence(BigInteger value);
}
