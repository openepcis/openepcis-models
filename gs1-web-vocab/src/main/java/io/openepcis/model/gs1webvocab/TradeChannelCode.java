//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for TradeChannelCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="TradeChannelCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="INSTORE_ONLY"/>
 *     <enumeration value="OMNICHANNEL"/>
 *     <enumeration value="ONLINE_ONLY"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "TradeChannelCode")
@XmlEnum
public enum TradeChannelCode {
  INSTORE_ONLY,
  OMNICHANNEL,
  ONLINE_ONLY;

  public String value() {
    return name();
  }

  public static TradeChannelCode fromValue(String v) {
    return valueOf(v);
  }
}
