package io.openepcis.model.interfaces;

public interface PriceSpecification {
    String getDutyFeeTaxAmount();

    void setDutyFeeTaxAmount(String value);

    String getDutyFeeTaxDescription();

    void setDutyFeeTaxDescription(String value);

    String getDutyFeeTaxRate();

    void setDutyFeeTaxRate(String value);

    QuantitativeValue getEligibleQuantity();

    void setEligibleQuantity(QuantitativeValue value);

    QuantitativeValue getEligibleQuantityMaximum();

    void setEligibleQuantityMaximum(QuantitativeValue value);

    QuantitativeValue getEligibleQuantityMinimum();

    void setEligibleQuantityMinimum(QuantitativeValue value);

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
