package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.FootwearFasteningTypeCode;
import io.openepcis.model.gs1webvocab.UpperTypeCode;

import java.util.List;

public interface Footwear<TM extends TextileMaterialDetails> {
    FootwearFasteningTypeCode getFootwearFasteningType();

    void setFootwearFasteningType(FootwearFasteningTypeCode value);

    UpperTypeCode getFootwearUpperType();

    void setFootwearUpperType(UpperTypeCode value);

    List<TM> getUpperMaterialType();

    void setUpperMaterialType(List<TM> value);
}
