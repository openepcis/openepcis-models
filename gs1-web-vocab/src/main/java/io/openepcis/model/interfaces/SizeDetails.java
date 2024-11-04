package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.SizeGroupCode;
import io.openepcis.model.gs1webvocab.SizeSystemCode;
import io.openepcis.model.gs1webvocab.SizeTypeCode;

public interface SizeDetails {
    QuantitativeValue getSizeDimension();

    void setSizeDimension(QuantitativeValue value);

    SizeGroupCode getSizeGroup();

    void setSizeGroup(SizeGroupCode value);

    SizeSystemCode getSizeSystem();

    void setSizeSystem(SizeSystemCode value);

    SizeTypeCode getSizeType();

    void setSizeType(SizeTypeCode value);
}
