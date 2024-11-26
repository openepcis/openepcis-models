package io.openepcis.model.interfaces;

import javax.xml.datatype.XMLGregorianCalendar;

public interface PriceSpecification<Q extends QuantitativeValue> {
    float getDutyFeeTaxAmount();

    void setDutyFeeTaxAmount(float value);

    String getDutyFeeTaxDescription();

    void setDutyFeeTaxDescription(String value);

    float getDutyFeeTaxRate();

    void setDutyFeeTaxRate(float value);

    Q getEligibleQuantity();

    void setEligibleQuantity(Q value);

    Q getEligibleQuantityMaximum();

    void setEligibleQuantityMaximum(Q value);

    Q getEligibleQuantityMinimum();

    void setEligibleQuantityMinimum(Q value);

    float getMaxPrice();

    void setMaxPrice(float value);

    float getMinPrice();

    void setMinPrice(float value);

    float getPrice();

    void setPrice(float value);

    String getPriceCurrency();

    void setPriceCurrency(String value);

    XMLGregorianCalendar getValidFrom();

    void setValidFrom(XMLGregorianCalendar value);

    XMLGregorianCalendar getValidThrough();

    void setValidThrough(XMLGregorianCalendar value);
}
