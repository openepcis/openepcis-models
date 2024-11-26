package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CertificationStatus;
import io.openepcis.model.gs1webvocab.OrganizationXMLImpl;

import javax.xml.datatype.XMLGregorianCalendar;

public interface CertificationDetails<O extends Organization> {
    String getCertificationAgency();

    void setCertificationAgency(String value);

    O getCertificationAgencyURL();

    void setCertificationAgencyURL(O value);

    XMLGregorianCalendar getCertificationAuditDate();

    void setCertificationAuditDate(XMLGregorianCalendar value);

    XMLGregorianCalendar getCertificationEndDate();

    void setCertificationEndDate(XMLGregorianCalendar value);

    String getCertificationIdentification();

    void setCertificationIdentification(String value);

    String getCertificationStandard();

    void setCertificationStandard(String value);

    XMLGregorianCalendar getCertificationStartDate();

    void setCertificationStartDate(XMLGregorianCalendar value);

    String getCertificationStatement();

    void setCertificationStatement(String value);

    CertificationStatus getCertificationStatus();

    void setCertificationStatus(CertificationStatus value);

    String getCertificationSubject();

    void setCertificationSubject(String value);

    String getCertificationType();

    void setCertificationType(String value);

    String getCertificationURI();

    void setCertificationURI(String value);

    String getCertificationValue();

    void setCertificationValue(String value);

    XMLGregorianCalendar getInitialCertificationDate();

    void setInitialCertificationDate(XMLGregorianCalendar value);
}
