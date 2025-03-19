package io.openepcis.model.interfaces;

import java.math.BigInteger;

public interface FoodBeverageTobaccoIngredientDetails {
  float getIngredientContentPercentage();

  void setIngredientContentPercentage(float value);

  String getIngredientName();

  void setIngredientName(String value);

  BigInteger getIngredientSequence();

  void setIngredientSequence(BigInteger value);
}
