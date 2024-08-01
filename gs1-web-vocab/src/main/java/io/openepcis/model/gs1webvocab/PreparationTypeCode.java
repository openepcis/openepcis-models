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
 * <p>Java class for PreparationTypeCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="PreparationTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AS_DRAINED"/>
 *     <enumeration value="BAKE"/>
 *     <enumeration value="BARBECUE"/>
 *     <enumeration value="BLANCH"/>
 *     <enumeration value="BLIND_BAKE"/>
 *     <enumeration value="BOIL"/>
 *     <enumeration value="BRAISE"/>
 *     <enumeration value="BROIL"/>
 *     <enumeration value="DEEP_FRY"/>
 *     <enumeration value="DOUBLE_STEAM"/>
 *     <enumeration value="FREEZE"/>
 *     <enumeration value="FRY"/>
 *     <enumeration value="GRIDDLE_FRY"/>
 *     <enumeration value="GRILL"/>
 *     <enumeration value="HEAT_AND_SERVE"/>
 *     <enumeration value="MICROWAVE"/>
 *     <enumeration value="PAN_FRY"/>
 *     <enumeration value="POACH"/>
 *     <enumeration value="PREPARED"/>
 *     <enumeration value="PRESSURE_COOK"/>
 *     <enumeration value="PRESSURE_FRY"/>
 *     <enumeration value="READY_TO_DRINK"/>
 *     <enumeration value="READY_TO_EAT"/>
 *     <enumeration value="RECONSTITUTE"/>
 *     <enumeration value="REFRIGERATE"/>
 *     <enumeration value="ROAST"/>
 *     <enumeration value="ROTISSERIE"/>
 *     <enumeration value="SAUTE"/>
 *     <enumeration value="SEAR"/>
 *     <enumeration value="SIMMER"/>
 *     <enumeration value="SMOKE"/>
 *     <enumeration value="STEAM"/>
 *     <enumeration value="STEW"/>
 *     <enumeration value="STIR_FRY"/>
 *     <enumeration value="THAW"/>
 *     <enumeration value="UNPREPARED"/>
 *     <enumeration value="UNSPECIFIED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "PreparationTypeCode")
@XmlEnum
public enum PreparationTypeCode {

    AS_DRAINED,
    BAKE,
    BARBECUE,
    BLANCH,
    BLIND_BAKE,
    BOIL,
    BRAISE,
    BROIL,
    DEEP_FRY,
    DOUBLE_STEAM,
    FREEZE,
    FRY,
    GRIDDLE_FRY,
    GRILL,
    HEAT_AND_SERVE,
    MICROWAVE,
    PAN_FRY,
    POACH,
    PREPARED,
    PRESSURE_COOK,
    PRESSURE_FRY,
    READY_TO_DRINK,
    READY_TO_EAT,
    RECONSTITUTE,
    REFRIGERATE,
    ROAST,
    ROTISSERIE,
    SAUTE,
    SEAR,
    SIMMER,
    SMOKE,
    STEAM,
    STEW,
    STIR_FRY,
    THAW,
    UNPREPARED,
    UNSPECIFIED;

    public String value() {
        return name();
    }

    public static PreparationTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
