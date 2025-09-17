package io.openepcis.model.interfaces;

public interface GeoCoordinates extends Geo {
  String getCoordinateReferenceSystem();

  void setCoordinateReferenceSystem(String value);

  String getElevation();

  void setElevation(String value);

  String getLatitude();

  void setLatitude(String value);

  String getLongitude();

  void setLongitude(String value);
}
