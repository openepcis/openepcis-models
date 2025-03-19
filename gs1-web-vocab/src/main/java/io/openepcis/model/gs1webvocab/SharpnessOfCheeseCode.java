//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for SharpnessOfCheeseCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="SharpnessOfCheeseCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="EXTRA_EXTRA_SHARP"/>
 *     <enumeration value="EXTRA_SHARP"/>
 *     <enumeration value="MILD"/>
 *     <enumeration value="REGULAR"/>
 *     <enumeration value="SHARP"/>
 *     <enumeration value="UNCLASSIFIED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "SharpnessOfCheeseCode")
@XmlEnum
public enum SharpnessOfCheeseCode {
  EXTRA_EXTRA_SHARP,
  EXTRA_SHARP,
  MILD,
  REGULAR,
  SHARP,
  UNCLASSIFIED;

  public String value() {
    return name();
  }

  public static SharpnessOfCheeseCode fromValue(String v) {
    return valueOf(v);
  }
}
