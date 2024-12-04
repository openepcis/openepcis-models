package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CertificationStatus;

import java.time.LocalDate;

public interface CertificationDetails<O extends Organization> {
    String getCertificationAgency();

    void setCertificationAgency(String value);

    O getCertificationAgencyURL();

    void setCertificationAgencyURL(O value);

    LocalDate getCertificationAuditDate();

    void setCertificationAuditDate(LocalDate value);

    LocalDate getCertificationEndDate();

    void setCertificationEndDate(LocalDate value);

    String getCertificationIdentification();

    void setCertificationIdentification(String value);

    String getCertificationStandard();

    void setCertificationStandard(String value);

    LocalDate getCertificationStartDate();

    void setCertificationStartDate(LocalDate value);

    String getCertificationStatement();

    void setCertificationStatement(String value);

    CertificationStatus getCertificationStatus();

    void setCertificationStatus(CertificationStatus value);

    Object getCertificationSubject();

    void setCertificationSubject(Object value);

    Object getCertificationType();

    void setCertificationType(Object value);

    String getCertificationURI();

    void setCertificationURI(String value);

    String getCertificationValue();

    void setCertificationValue(String value);

    LocalDate getInitialCertificationDate();

    void setInitialCertificationDate(LocalDate value);
}
