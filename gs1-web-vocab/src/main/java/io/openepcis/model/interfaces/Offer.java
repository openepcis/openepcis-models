package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Offer {
    PaymentMethod getAcceptedPaymentMethod();

    void setAcceptedPaymentMethod(PaymentMethod value);

    String getAvailabilityEnds();

    void setAvailabilityEnds(String value);

    String getAvailabilityStarts();

    void setAvailabilityStarts(String value);

    PlaceXMLImpl getAvailableAtOrFrom();

    void setAvailableAtOrFrom(PlaceXMLImpl value);

    QuantitativeValue getEligibleQuantity();

    void setEligibleQuantity(QuantitativeValue value);

    QuantitativeValue getEligibleQuantityMaximum();

    void setEligibleQuantityMaximum(QuantitativeValue value);

    QuantitativeValue getEligibleQuantityMinimum();

    void setEligibleQuantityMinimum(QuantitativeValue value);

    ProductXMLImpl getItemOffered();

    void setItemOffered(ProductXMLImpl value);

    String getOfferDescription();

    void setOfferDescription(String value);

    DiscountXMLImpl getOfferDiscount();

    void setOfferDiscount(DiscountXMLImpl value);

    ReferencedFileDetails getOfferRedemptionURL();

    void setOfferRedemptionURL(ReferencedFileDetails value);

    String getPaymentTerms();

    void setPaymentTerms(String value);

    PriceSpecificationXMLImpl getPriceSpecification();

    void setPriceSpecification(PriceSpecificationXMLImpl value);

    OrganizationXMLImpl getSeeker();

    void setSeeker(OrganizationXMLImpl value);

    OrganizationXMLImpl getSeller();

    void setSeller(OrganizationXMLImpl value);

    WarrantyPromise getWarranty();

    void setWarranty(WarrantyPromise value);
}
