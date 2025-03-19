//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for DiscountTypeCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="DiscountTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BOGO"/>
 *     <enumeration value="DISCOUNTED_ITEM"/>
 *     <enumeration value="FREE_GIFT"/>
 *     <enumeration value="FREE_SHIPPING"/>
 *     <enumeration value="OTHER"/>
 *     <enumeration value="PERCENTAGE_OFF"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "DiscountTypeCode")
@XmlEnum
public enum DiscountTypeCode {
  BOGO,
  DISCOUNTED_ITEM,
  FREE_GIFT,
  FREE_SHIPPING,
  OTHER,
  PERCENTAGE_OFF;

  public String value() {
    return name();
  }

  public static DiscountTypeCode fromValue(String v) {
    return valueOf(v);
  }
}
