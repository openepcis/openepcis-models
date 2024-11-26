package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.StatusType;

import javax.xml.datatype.XMLGregorianCalendar;

public interface OrganizationStatusHistory {
    StatusType getOrganizationStatus();

    void setOrganizationStatus(StatusType value);

    XMLGregorianCalendar getStatusTimestamp();

    void setStatusTimestamp(XMLGregorianCalendar value);
}
