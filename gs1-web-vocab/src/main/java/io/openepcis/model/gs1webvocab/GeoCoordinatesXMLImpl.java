//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.GeoCoordinates;
import jakarta.xml.bind.annotation.*;

/**
 * The geographic coordinates of a place or event.
 *
 * <p>Java class for GeoCoordinates complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="GeoCoordinates">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="coordinateReferenceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="elevation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="longitude" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "GeoCoordinates",
    propOrder = {"coordinateReferenceSystem", "elevation", "latitude", "longitude"})
public class GeoCoordinatesXMLImpl implements GeoCoordinates {

  @XmlElement(required = true)
  @XmlSchemaType(name = "anyURI")
  protected String coordinateReferenceSystem;

  @XmlElement(required = true)
  protected String elevation;

  @XmlElement(required = true)
  protected String latitude;

  @XmlElement(required = true)
  protected String longitude;

  /**
   * Gets the value of the coordinateReferenceSystem property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getCoordinateReferenceSystem() {
    return coordinateReferenceSystem;
  }

  /**
   * Sets the value of the coordinateReferenceSystem property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setCoordinateReferenceSystem(String value) {
    this.coordinateReferenceSystem = value;
  }

  /**
   * Gets the value of the elevation property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getElevation() {
    return elevation;
  }

  /**
   * Sets the value of the elevation property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setElevation(String value) {
    this.elevation = value;
  }

  /**
   * Gets the value of the latitude property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the latitude property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setLatitude(String value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the longitude property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setLongitude(String value) {
    this.longitude = value;
  }
}
