//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for PackagingFunctionCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="PackagingFunctionCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ANTISEPTIC"/>
 *     <enumeration value="ANTI_TAMPERING"/>
 *     <enumeration value="COATED"/>
 *     <enumeration value="COMPRESSED"/>
 *     <enumeration value="DISPENSER"/>
 *     <enumeration value="GIFT_WRAPPED"/>
 *     <enumeration value="ISOTHERMIC"/>
 *     <enumeration value="MODIFIED_ATMOSPHERE"/>
 *     <enumeration value="OXYGEN_INFUSED"/>
 *     <enumeration value="PEEL_OFF"/>
 *     <enumeration value="PINPACK"/>
 *     <enumeration value="PROTECTED"/>
 *     <enumeration value="REINFORCED"/>
 *     <enumeration value="SIFT_PROOF"/>
 *     <enumeration value="TAMPER_EVIDENT"/>
 *     <enumeration value="WATER_RESISTANT"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "PackagingFunctionCode")
@XmlEnum
public enum PackagingFunctionCode {
  ANTISEPTIC,
  ANTI_TAMPERING,
  COATED,
  COMPRESSED,
  DISPENSER,
  GIFT_WRAPPED,
  ISOTHERMIC,
  MODIFIED_ATMOSPHERE,
  OXYGEN_INFUSED,
  PEEL_OFF,
  PINPACK,
  PROTECTED,
  REINFORCED,
  SIFT_PROOF,
  TAMPER_EVIDENT,
  WATER_RESISTANT;

  public String value() {
    return name();
  }

  public static PackagingFunctionCode fromValue(String v) {
    return valueOf(v);
  }
}
