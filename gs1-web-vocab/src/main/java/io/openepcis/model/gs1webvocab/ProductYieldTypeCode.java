//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for ProductYieldTypeCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="ProductYieldTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AFTER_COOKING"/>
 *     <enumeration value="AFTER_DILUTION"/>
 *     <enumeration value="DRAINED_WEIGHT"/>
 *     <enumeration value="UNSPECIFIED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "ProductYieldTypeCode")
@XmlEnum
public enum ProductYieldTypeCode {
  AFTER_COOKING,
  AFTER_DILUTION,
  DRAINED_WEIGHT,
  UNSPECIFIED;

  public String value() {
    return name();
  }

  public static ProductYieldTypeCode fromValue(String v) {
    return valueOf(v);
  }
}
