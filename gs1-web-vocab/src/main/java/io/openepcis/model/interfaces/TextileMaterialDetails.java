package io.openepcis.model.interfaces;

import java.util.LinkedHashMap;

public interface TextileMaterialDetails<QV extends QuantitativeValue> {
    LinkedHashMap<String, String> getTextileMaterialDescription();

    void setTextileMaterialDescription(LinkedHashMap<String, String> value);

    float getTextileMaterialPercentage();

    void setTextileMaterialPercentage(float value);

    LinkedHashMap<String, String> getTextileMaterialThreadCount();

    void setTextileMaterialThreadCount(LinkedHashMap<String, String> value);

    QV getTextileMaterialWeight();

    void setTextileMaterialWeight(QV value);
}
