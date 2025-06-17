package io.openepcis.model.interfaces;

import java.math.BigInteger;
import java.util.LinkedHashMap;

public interface FoodBeverageTobaccoIngredientDetails {
    float getIngredientContentPercentage();

    void setIngredientContentPercentage(float value);

    LinkedHashMap<String, String> getIngredientName();

    void setIngredientName(LinkedHashMap<String, String> value);

    BigInteger getIngredientSequence();

    void setIngredientSequence(BigInteger value);
}
