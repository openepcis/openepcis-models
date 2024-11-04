package io.openepcis.model.interfaces;

public interface TextileMaterialDetails {
    String getTextileMaterialDescription();

    void setTextileMaterialDescription(String value);

    String getTextileMaterialPercentage();

    void setTextileMaterialPercentage(String value);

    String getTextileMaterialThreadCount();

    void setTextileMaterialThreadCount(String value);

    QuantitativeValue getTextileMaterialWeight();

    void setTextileMaterialWeight(QuantitativeValue value);
}
