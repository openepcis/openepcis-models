package io.openepcis.model.interfaces;

import javax.xml.datatype.XMLGregorianCalendar;

public interface TargetMarketDetails<C extends Country> {
    XMLGregorianCalendar getConsumerFirstAvailabilityDateTime();

    void setConsumerFirstAvailabilityDateTime(XMLGregorianCalendar value);

    C getTargetMarketCountries();

    void setTargetMarketCountries(C value);
}
