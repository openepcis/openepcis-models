//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for FootwearFasteningTypeCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="FootwearFasteningTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="MULTIPLE_FASTENING"/>
 *     <enumeration value="SHOE_LACE"/>
 *     <enumeration value="SLIP_ON_WITHOUT_ELASTIC"/>
 *     <enumeration value="SLIP_ON_WITH_ELASTIC"/>
 *     <enumeration value="STRAP"/>
 *     <enumeration value="UNCLASSIFIED"/>
 *     <enumeration value="UNIDENTIFIED"/>
 *     <enumeration value="VELCRO"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "FootwearFasteningTypeCode")
@XmlEnum
public enum FootwearFasteningTypeCode {

    MULTIPLE_FASTENING,
    SHOE_LACE,
    SLIP_ON_WITHOUT_ELASTIC,
    SLIP_ON_WITH_ELASTIC,
    STRAP,
    UNCLASSIFIED,
    UNIDENTIFIED,
    VELCRO;

    public String value() {
        return name();
    }

    public static FootwearFasteningTypeCode fromValue(String v) {
        return valueOf(v);
    }

}