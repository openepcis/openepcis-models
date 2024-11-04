package io.openepcis.model.interfaces;

public interface GeoShape {
    String getCircle();

    void setCircle(String value);

    String getLine();

    void setLine(String value);

    String getPolygon();

    void setPolygon(String value);
}
