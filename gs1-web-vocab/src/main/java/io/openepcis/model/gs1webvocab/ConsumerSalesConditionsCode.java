//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for ConsumerSalesConditionsCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="ConsumerSalesConditionsCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BTC"/>
 *     <enumeration value="OTC"/>
 *     <enumeration value="PRESCRIPTION_REQUIRED"/>
 *     <enumeration value="RESTRICTED_TO_SELL_16"/>
 *     <enumeration value="RESTRICTED_TO_SELL_18"/>
 *     <enumeration value="RESTRICTED_TO_SELL_21"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "ConsumerSalesConditionsCode")
@XmlEnum
public enum ConsumerSalesConditionsCode {
  BTC,
  OTC,
  PRESCRIPTION_REQUIRED,
  RESTRICTED_TO_SELL_16,
  RESTRICTED_TO_SELL_18,
  RESTRICTED_TO_SELL_21;

  public String value() {
    return name();
  }

  public static ConsumerSalesConditionsCode fromValue(String v) {
    return valueOf(v);
  }
}
