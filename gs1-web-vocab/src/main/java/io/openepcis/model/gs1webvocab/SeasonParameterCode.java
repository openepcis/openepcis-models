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
 * <p>Java class for SeasonParameterCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="SeasonParameterCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ALL_YEAR"/>
 *     <enumeration value="AUTUMN"/>
 *     <enumeration value="AUTUMN_WINTER"/>
 *     <enumeration value="SPRING"/>
 *     <enumeration value="SPRING_SUMMER"/>
 *     <enumeration value="SUMMER"/>
 *     <enumeration value="WINTER"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "SeasonParameterCode")
@XmlEnum
public enum SeasonParameterCode {

    ALL_YEAR,
    AUTUMN,
    AUTUMN_WINTER,
    SPRING,
    SPRING_SUMMER,
    SUMMER,
    WINTER;

    public String value() {
        return name();
    }

    public static SeasonParameterCode fromValue(String v) {
        return valueOf(v);
    }

}