package io.openepcis.model.interfaces;

public interface PriceSpecification<Q extends QuantitativeValue> {
    String getDutyFeeTaxAmount();

    void setDutyFeeTaxAmount(String value);

    String getDutyFeeTaxDescription();

    void setDutyFeeTaxDescription(String value);

    String getDutyFeeTaxRate();

    void setDutyFeeTaxRate(String value);

    Q getEligibleQuantity();

    void setEligibleQuantity(Q value);

    Q getEligibleQuantityMaximum();

    void setEligibleQuantityMaximum(Q value);

    Q getEligibleQuantityMinimum();

    void setEligibleQuantityMinimum(Q value);

    String getMaxPrice();

    void setMaxPrice(String value);

    String getMinPrice();

    void setMinPrice(String value);

    String getPrice();

    void setPrice(String value);

    String getPriceCurrency();

    void setPriceCurrency(String value);

    String getValidFrom();

    void setValidFrom(String value);

    String getValidThrough();

    void setValidThrough(String value);
}
