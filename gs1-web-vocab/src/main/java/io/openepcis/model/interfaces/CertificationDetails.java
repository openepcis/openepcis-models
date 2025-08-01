package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.CertificationStatus;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public interface CertificationDetails<O extends Organization> {
    LinkedHashMap<String, String> getCertificationAgency();

    void setCertificationAgency(LinkedHashMap<String, String> value);

    O getCertificationAgencyURL();

    void setCertificationAgencyURL(O value);

    LocalDate getCertificationAuditDate();

    void setCertificationAuditDate(LocalDate value);

    LocalDate getCertificationEndDate();

    void setCertificationEndDate(LocalDate value);

    String getCertificationIdentification();

    void setCertificationIdentification(String value);

    LinkedHashMap<String, String> getCertificationStandard();

    void setCertificationStandard(LinkedHashMap<String, String> value);

    LocalDate getCertificationStartDate();

    void setCertificationStartDate(LocalDate value);

    LinkedHashMap<String, String> getCertificationStatement();

    void setCertificationStatement(LinkedHashMap<String, String> value);

    CertificationStatus getCertificationStatus();

    void setCertificationStatus(CertificationStatus value);

    String getCertificationSubject();

    void setCertificationSubject(String value);

    String getCertificationType();

    void setCertificationType(String value);

    String getCertificationURI();

    void setCertificationURI(String value);

    LinkedHashMap<String, String> getCertificationValue();

    void setCertificationValue(LinkedHashMap<String, String> value);

    LocalDate getInitialCertificationDate();

    void setInitialCertificationDate(LocalDate value);
}
