package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CertificationStatus;
import io.openepcis.model.gs1webvocab.OrganizationXMLImpl;

public interface CertificationDetails<O extends Organization> {
    String getCertificationAgency();

    void setCertificationAgency(String value);

    O getCertificationAgencyURL();

    void setCertificationAgencyURL(O value);

    String getCertificationAuditDate();

    void setCertificationAuditDate(String value);

    String getCertificationEndDate();

    void setCertificationEndDate(String value);

    String getCertificationIdentification();

    void setCertificationIdentification(String value);

    String getCertificationStandard();

    void setCertificationStandard(String value);

    String getCertificationStartDate();

    void setCertificationStartDate(String value);

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

    String getInitialCertificationDate();

    void setInitialCertificationDate(String value);
}
