package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.OrganicClaimAgencyCode;

public interface OrganicClaimDetails {
    OrganicClaimAgencyCode getOrganicClaimAgency();

    void setOrganicClaimAgency(OrganicClaimAgencyCode value);

    String getOrganicPercentClaim();

    void setOrganicPercentClaim(String value);
}
