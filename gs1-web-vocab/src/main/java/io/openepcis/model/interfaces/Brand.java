package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface Brand {
    LinkedHashMap<String, String> getBrandName();

    void setBrandName(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getSubBrandName();

    void setSubBrandName(LinkedHashMap<String, String> value);
}
