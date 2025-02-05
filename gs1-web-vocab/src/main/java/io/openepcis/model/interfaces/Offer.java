package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

import java.time.LocalDateTime;
import java.util.List;

public interface Offer<P extends Place,Q extends QuantitativeValue,PR extends Product,D extends Discount
        ,R extends ReferencedFileDetails,PS extends PriceSpecification,W extends WarrantyPromise,O extends Organization>{
    PaymentMethod getAcceptedPaymentMethod();

    void setAcceptedPaymentMethod(PaymentMethod value);

    LocalDateTime getAvailabilityEnds();

    void setAvailabilityEnds(LocalDateTime value);

    LocalDateTime getAvailabilityStarts();

    void setAvailabilityStarts(LocalDateTime value);

    P getAvailableAtOrFrom();

    void setAvailableAtOrFrom(P value);

    Q getEligibleQuantity();

    void setEligibleQuantity(Q value);

    Q getEligibleQuantityMaximum();

    void setEligibleQuantityMaximum(Q value);

    Q getEligibleQuantityMinimum();

    void setEligibleQuantityMinimum(Q value);

    PR getItemOffered();

    void setItemOffered(PR value);

    String getOfferDescription();

    void setOfferDescription(String value);

    D getOfferDiscount();

    void setOfferDiscount(D value);

    R getOfferRedemptionURL();

    void setOfferRedemptionURL(R value);

    String getPaymentTerms();

    void setPaymentTerms(String value);

    PS getPriceSpecification();

    void setPriceSpecification(PS value);

    O getSeeker();

    void setSeeker(O value);

    O getSeller();

    void setSeller(O value);

    W getWarranty();

    void setWarranty(W value);
}
