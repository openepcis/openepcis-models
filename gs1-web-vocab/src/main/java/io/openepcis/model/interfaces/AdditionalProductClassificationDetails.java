package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface AdditionalProductClassificationDetails {
    String getAdditionalProductClassificationCode();

    void setAdditionalProductClassificationCode(String value);

    LinkedHashMap<String, String> getAdditionalProductClassificationCodeDescription();

    void setAdditionalProductClassificationCodeDescription(LinkedHashMap<String, String> value);

    String getAdditionalProductClassificationValue();

    void setAdditionalProductClassificationValue(String value);
}
