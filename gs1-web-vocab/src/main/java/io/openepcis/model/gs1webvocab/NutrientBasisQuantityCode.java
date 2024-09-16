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
 * <p>Java class for NutrientBasisQuantityCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="NutrientBasisQuantityCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BY_MEASURE"/>
 *     <enumeration value="BY_SERVING"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "NutrientBasisQuantityCode")
@XmlEnum
public enum NutrientBasisQuantityCode {

    BY_MEASURE,
    BY_SERVING;

    public String value() {
        return name();
    }

    public static NutrientBasisQuantityCode fromValue(String v) {
        return valueOf(v);
    }

}
