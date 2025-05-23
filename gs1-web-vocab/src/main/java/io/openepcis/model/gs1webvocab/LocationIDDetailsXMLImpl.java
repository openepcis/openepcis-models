//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import io.openepcis.model.interfaces.LocationIDDetails;
import jakarta.xml.bind.annotation.*;

/**
 * Government bodies, trade organisations, and other parties issue identifiers that are associated
 * to locations. Linking these identifiers to GLN and one another supports consolidating records,
 * mapping related, collaborative identifiers, enhances search ability and enables more efficient
 * transitions between identifiers. This class provides a mechanism for connecting and sharing
 * location identifiers.
 *
 * <p>Java class for LocationID_Details complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="LocationID_Details">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="locationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="locationID_Qualifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="locationID_Type" type="{}LocationID_Type"/>
 *         <element name="locationID_URI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "LocationID_Details",
    propOrder = {"locationID", "locationIDQualifier", "locationIDType", "locationIDURI"})
public class LocationIDDetailsXMLImpl implements LocationIDDetails {

  @XmlElement(required = true)
  protected String locationID;

  @XmlElement(name = "locationID_Qualifier", required = true)
  protected String locationIDQualifier;

  @XmlElement(name = "locationID_Type", required = true)
  @XmlSchemaType(name = "string")
  protected LocationIDType locationIDType;

  @XmlElement(name = "locationID_URI", required = true)
  protected String locationIDURI;

  /**
   * Gets the value of the locationID property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getLocationID() {
    return locationID;
  }

  /**
   * Sets the value of the locationID property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setLocationID(String value) {
    this.locationID = value;
  }

  /**
   * Gets the value of the locationIDQualifier property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getLocationIDQualifier() {
    return locationIDQualifier;
  }

  /**
   * Sets the value of the locationIDQualifier property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setLocationIDQualifier(String value) {
    this.locationIDQualifier = value;
  }

  /**
   * Gets the value of the locationIDType property.
   *
   * @return possible object is {@link LocationIDType }
   */
  @Override
  public LocationIDType getLocationIDType() {
    return locationIDType;
  }

  /**
   * Sets the value of the locationIDType property.
   *
   * @param value allowed object is {@link LocationIDType }
   */
  @Override
  public void setLocationIDType(LocationIDType value) {
    this.locationIDType = value;
  }

  /**
   * Gets the value of the locationIDURI property.
   *
   * @return possible object is {@link String }
   */
  @Override
  public String getLocationIDURI() {
    return locationIDURI;
  }

  /**
   * Sets the value of the locationIDURI property.
   *
   * @param value allowed object is {@link String }
   */
  @Override
  public void setLocationIDURI(String value) {
    this.locationIDURI = value;
  }
}
