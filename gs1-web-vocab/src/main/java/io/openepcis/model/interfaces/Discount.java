package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;
import java.math.BigInteger;

public interface Discount<
    P extends PriceSpecification, A extends AdditionalProductClassificationDetails> {
  boolean getDiscountRepeatsPerMultipleMinimum();

  void setDiscountRepeatsPerMultipleMinimum(boolean value);

  DiscountTypeCode getDiscountType();

  void setDiscountType(DiscountTypeCode value);

  TradeChannelCode getEligibleTradeChannel();

  void setEligibleTradeChannel(TradeChannelCode value);

  P getExactDiscountAmount();

  void setExactDiscountAmount(P value);

  float getExactDiscountPercentage();

  void setExactDiscountPercentage(float value);

  String getExclusionDescription();

  void setExclusionDescription(String value);

  boolean getIsOnlyAvailableThroughRetailer();

  void setIsOnlyAvailableThroughRetailer(boolean value);

  boolean getIsOnlyWithMailingListSignup();

  void setIsOnlyWithMailingListSignup(boolean value);

  PaymentMethod getIsOnlyWithPaymentCard();

  void setIsOnlyWithPaymentCard(PaymentMethod value);

  boolean getIsOnlyWithRetailerLoyaltyCard();

  void setIsOnlyWithRetailerLoyaltyCard(boolean value);

  boolean getIsOnlyWithRetailerPaymentCard();

  void setIsOnlyWithRetailerPaymentCard(boolean value);

  boolean getIsPromoterExclusiveOffer();

  void setIsPromoterExclusiveOffer(boolean value);

  P getMaximumDiscountAmount();

  void setMaximumDiscountAmount(P value);

  float getMaximumDiscountPercentage();

  void setMaximumDiscountPercentage(float value);

  BigInteger getMaximumQualifyingItems();

  void setMaximumQualifyingItems(BigInteger value);

  P getMaximumQualifyingSpend();

  void setMaximumQualifyingSpend(P value);

  P getMinimumDiscountAmount();

  void setMinimumDiscountAmount(P value);

  float getMinimumDiscountPercentage();

  void setMinimumDiscountPercentage(float value);

  BigInteger getMinimumQualifyingItems();

  void setMinimumQualifyingItems(BigInteger value);

  P getMinimumQualifyingSpend();

  void setMinimumQualifyingSpend(P value);

  OfferRedemptionTypeCode getOfferRedemptionType();

  void setOfferRedemptionType(OfferRedemptionTypeCode value);

  String getOfferRestrictionDescription();

  void setOfferRestrictionDescription(String value);

  String getQualifyingBrandName();

  void setQualifyingBrandName(String value);

  String getQualifyingGPCs();

  void setQualifyingGPCs(String value);

  String getQualifyingProductCategoryDescription();

  void setQualifyingProductCategoryDescription(String value);

  A getQualifyingProductClassificationCode();

  void setQualifyingProductClassificationCode(A value);

  String getQualifyingProductGTINs();

  void setQualifyingProductGTINs(String value);

  String getQualifyingSubBrandName();

  void setQualifyingSubBrandName(String value);

  boolean getSelectedProductsOnly();

  void setSelectedProductsOnly(boolean value);
}
