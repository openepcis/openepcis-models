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
 * <p>Java class for SportingActivityTypeCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="SportingActivityTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AMERICAN_FOOTBALL"/>
 *     <enumeration value="ARCHERY"/>
 *     <enumeration value="BADMINTON"/>
 *     <enumeration value="BASEBALL"/>
 *     <enumeration value="BASKETBALL"/>
 *     <enumeration value="BOXING"/>
 *     <enumeration value="CLIMBING"/>
 *     <enumeration value="CRICKET"/>
 *     <enumeration value="CYCLING"/>
 *     <enumeration value="DIVING"/>
 *     <enumeration value="EQUESTRIAN"/>
 *     <enumeration value="FENCING"/>
 *     <enumeration value="FISHING"/>
 *     <enumeration value="FOOTBALL"/>
 *     <enumeration value="GOLF"/>
 *     <enumeration value="GYMNASTICS"/>
 *     <enumeration value="HOCKEY"/>
 *     <enumeration value="ICE_HOCKEY"/>
 *     <enumeration value="ICE_SKATING"/>
 *     <enumeration value="MOTOR_CYCLING"/>
 *     <enumeration value="RUGBY"/>
 *     <enumeration value="RUNNING"/>
 *     <enumeration value="SKIING"/>
 *     <enumeration value="SQUASH"/>
 *     <enumeration value="SURFING"/>
 *     <enumeration value="SWIMMING"/>
 *     <enumeration value="TENNIS"/>
 *     <enumeration value="UNCLASSIFIED"/>
 *     <enumeration value="UNIDENTIFIED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "SportingActivityTypeCode")
@XmlEnum
public enum SportingActivityTypeCode {

    AMERICAN_FOOTBALL,
    ARCHERY,
    BADMINTON,
    BASEBALL,
    BASKETBALL,
    BOXING,
    CLIMBING,
    CRICKET,
    CYCLING,
    DIVING,
    EQUESTRIAN,
    FENCING,
    FISHING,
    FOOTBALL,
    GOLF,
    GYMNASTICS,
    HOCKEY,
    ICE_HOCKEY,
    ICE_SKATING,
    MOTOR_CYCLING,
    RUGBY,
    RUNNING,
    SKIING,
    SQUASH,
    SURFING,
    SWIMMING,
    TENNIS,
    UNCLASSIFIED,
    UNIDENTIFIED;

    public String value() {
        return name();
    }

    public static SportingActivityTypeCode fromValue(String v) {
        return valueOf(v);
    }

}