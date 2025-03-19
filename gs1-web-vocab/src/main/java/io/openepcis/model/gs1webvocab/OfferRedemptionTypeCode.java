//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for OfferRedemptionTypeCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="OfferRedemptionTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="COUPON_CODE"/>
 *     <enumeration value="GIFT_CARD"/>
 *     <enumeration value="REBATE"/>
 *     <enumeration value="SALE"/>
 *     <enumeration value="SINGLE_USE_CODE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "OfferRedemptionTypeCode")
@XmlEnum
public enum OfferRedemptionTypeCode {
  COUPON_CODE,
  GIFT_CARD,
  REBATE,
  SALE,
  SINGLE_USE_CODE;

  public String value() {
    return name();
  }

  public static OfferRedemptionTypeCode fromValue(String v) {
    return valueOf(v);
  }
}
