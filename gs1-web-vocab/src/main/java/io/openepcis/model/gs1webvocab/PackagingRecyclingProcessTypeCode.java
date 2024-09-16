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
 * <p>Java class for PackagingRecyclingProcessTypeCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="PackagingRecyclingProcessTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="COMPOSTABLE"/>
 *     <enumeration value="ENERGY_RECOVERABLE"/>
 *     <enumeration value="RECYCLABLE"/>
 *     <enumeration value="REUSABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "PackagingRecyclingProcessTypeCode")
@XmlEnum
public enum PackagingRecyclingProcessTypeCode {

    COMPOSTABLE,
    ENERGY_RECOVERABLE,
    RECYCLABLE,
    REUSABLE;

    public String value() {
        return name();
    }

    public static PackagingRecyclingProcessTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
