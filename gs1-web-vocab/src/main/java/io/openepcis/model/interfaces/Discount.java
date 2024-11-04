package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Discount {
    String getDiscountRepeatsPerMultipleMinimum();

    void setDiscountRepeatsPerMultipleMinimum(String value);

    DiscountTypeCode getDiscountType();

    void setDiscountType(DiscountTypeCode value);

    TradeChannelCode getEligibleTradeChannel();

    void setEligibleTradeChannel(TradeChannelCode value);

    PriceSpecificationXMLImpl getExactDiscountAmount();

    void setExactDiscountAmount(PriceSpecificationXMLImpl value);

    String getExactDiscountPercentage();

    void setExactDiscountPercentage(String value);

    String getExclusionDescription();

    void setExclusionDescription(String value);

    String getIsOnlyAvailableThroughRetailer();

    void setIsOnlyAvailableThroughRetailer(String value);

    String getIsOnlyWithMailingListSignup();

    void setIsOnlyWithMailingListSignup(String value);

    PaymentMethod getIsOnlyWithPaymentCard();

    void setIsOnlyWithPaymentCard(PaymentMethod value);

    String getIsOnlyWithRetailerLoyaltyCard();

    void setIsOnlyWithRetailerLoyaltyCard(String value);

    String getIsOnlyWithRetailerPaymentCard();

    void setIsOnlyWithRetailerPaymentCard(String value);

    String getIsPromoterExclusiveOffer();

    void setIsPromoterExclusiveOffer(String value);

    PriceSpecificationXMLImpl getMaximumDiscountAmount();

    void setMaximumDiscountAmount(PriceSpecificationXMLImpl value);

    String getMaximumDiscountPercentage();

    void setMaximumDiscountPercentage(String value);

    String getMaximumQualifyingItems();

    void setMaximumQualifyingItems(String value);

    PriceSpecificationXMLImpl getMaximumQualifyingSpend();

    void setMaximumQualifyingSpend(PriceSpecificationXMLImpl value);

    PriceSpecificationXMLImpl getMinimumDiscountAmount();

    void setMinimumDiscountAmount(PriceSpecificationXMLImpl value);

    String getMinimumDiscountPercentage();

    void setMinimumDiscountPercentage(String value);

    String getMinimumQualifyingItems();

    void setMinimumQualifyingItems(String value);

    PriceSpecificationXMLImpl getMinimumQualifyingSpend();

    void setMinimumQualifyingSpend(PriceSpecificationXMLImpl value);

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

    AdditionalProductClassificationDetails getQualifyingProductClassificationCode();

    void setQualifyingProductClassificationCode(AdditionalProductClassificationDetails value);

    String getQualifyingProductGTINs();

    void setQualifyingProductGTINs(String value);

    String getQualifyingSubBrandName();

    void setQualifyingSubBrandName(String value);

    String getSelectedProductsOnly();

    void setSelectedProductsOnly(String value);
}
