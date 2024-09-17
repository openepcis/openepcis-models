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
 * <p>Java class for FoodBeverageRefrigerationClaimCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="FoodBeverageRefrigerationClaimCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CAN_BE_REFRIGERATED"/>
 *     <enumeration value="MUST_BE_REFRIGERATED"/>
 *     <enumeration value="SHELF_STABLE"/>
 *     <enumeration value="UNIDENTIFIED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "FoodBeverageRefrigerationClaimCode")
@XmlEnum
public enum FoodBeverageRefrigerationClaimCode {

    CAN_BE_REFRIGERATED,
    MUST_BE_REFRIGERATED,
    SHELF_STABLE,
    UNIDENTIFIED;

    public String value() {
        return name();
    }

    public static FoodBeverageRefrigerationClaimCode fromValue(String v) {
        return valueOf(v);
    }

}