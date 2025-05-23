//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for GLN_TypeCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="GLN_TypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="DIGITAL_LOCATION"/>
 *     <enumeration value="FIXED_PHYSICAL_LOCATION"/>
 *     <enumeration value="FUNCTION"/>
 *     <enumeration value="LEGAL_ENTITY"/>
 *     <enumeration value="MOBILE_PHYSICAL_LOCATION"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "GLN_TypeCode")
@XmlEnum
public enum GLNTypeCode {
  DIGITAL_LOCATION,
  FIXED_PHYSICAL_LOCATION,
  FUNCTION,
  LEGAL_ENTITY,
  MOBILE_PHYSICAL_LOCATION;

  public String value() {
    return name();
  }

  public static GLNTypeCode fromValue(String v) {
    return valueOf(v);
  }
}
