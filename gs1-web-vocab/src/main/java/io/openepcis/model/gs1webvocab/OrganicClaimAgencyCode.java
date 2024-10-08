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
 * <p>Java class for OrganicClaimAgencyCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="OrganicClaimAgencyCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BFA"/>
 *     <enumeration value="BIOLAND"/>
 *     <enumeration value="DEMETER_BUND"/>
 *     <enumeration value="DEMETER_INTERNATIONAL"/>
 *     <enumeration value="ECOLAND"/>
 *     <enumeration value="ECOVIN"/>
 *     <enumeration value="EPA"/>
 *     <enumeration value="FDA"/>
 *     <enumeration value="FSA"/>
 *     <enumeration value="GAA"/>
 *     <enumeration value="IFOA"/>
 *     <enumeration value="IFOAM"/>
 *     <enumeration value="NATURLAND"/>
 *     <enumeration value="QAI"/>
 *     <enumeration value="SUDITIROL"/>
 *     <enumeration value="USDA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "OrganicClaimAgencyCode")
@XmlEnum
public enum OrganicClaimAgencyCode {

    BFA,
    BIOLAND,
    DEMETER_BUND,
    DEMETER_INTERNATIONAL,
    ECOLAND,
    ECOVIN,
    EPA,
    FDA,
    FSA,
    GAA,
    IFOA,
    IFOAM,
    NATURLAND,
    QAI,
    SUDITIROL,
    USDA;

    public String value() {
        return name();
    }

    public static OrganicClaimAgencyCode fromValue(String v) {
        return valueOf(v);
    }

}
