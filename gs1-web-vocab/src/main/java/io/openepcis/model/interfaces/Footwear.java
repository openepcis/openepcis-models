package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.FootwearFasteningTypeCode;
import io.openepcis.model.gs1webvocab.UpperTypeCode;

public interface Footwear {
    FootwearFasteningTypeCode getFootwearFasteningType();

    void setFootwearFasteningType(FootwearFasteningTypeCode value);

    UpperTypeCode getFootwearUpperType();

    void setFootwearUpperType(UpperTypeCode value);

    TextileMaterialDetails getUpperMaterialType();

    void setUpperMaterialType(TextileMaterialDetails value);
}
