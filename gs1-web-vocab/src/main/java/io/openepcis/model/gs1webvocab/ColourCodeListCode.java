//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for ColourCodeListCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="ColourCodeListCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BUYER"/>
 *     <enumeration value="IFPS"/>
 *     <enumeration value="NCS"/>
 *     <enumeration value="NRF"/>
 *     <enumeration value="PANTONE_HEXACHROME"/>
 *     <enumeration value="PANTONE_MATCHING"/>
 *     <enumeration value="PANTONE_PROCESS_COLOUR"/>
 *     <enumeration value="PANTONE_TEXTILE"/>
 *     <enumeration value="RAL"/>
 *     <enumeration value="SELLER"/>
 *     <enumeration value="WWS"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "ColourCodeListCode")
@XmlEnum
public enum ColourCodeListCode {
  BUYER,
  IFPS,
  NCS,
  NRF,
  PANTONE_HEXACHROME,
  PANTONE_MATCHING,
  PANTONE_PROCESS_COLOUR,
  PANTONE_TEXTILE,
  RAL,
  SELLER,
  WWS;

  public String value() {
    return name();
  }

  public static ColourCodeListCode fromValue(String v) {
    return valueOf(v);
  }
}
