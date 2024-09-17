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
 * <p>Java class for AnatomicalFormCode</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="AnatomicalFormCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="BELLY"/>
 *     <enumeration value="BLOOD"/>
 *     <enumeration value="BONE"/>
 *     <enumeration value="BRAIN"/>
 *     <enumeration value="CARCASS_NONPOULTRY"/>
 *     <enumeration value="DIAPHRAM"/>
 *     <enumeration value="ESOPHAGUS"/>
 *     <enumeration value="FAT"/>
 *     <enumeration value="FEET"/>
 *     <enumeration value="FOREQUARTER"/>
 *     <enumeration value="GIZZARD"/>
 *     <enumeration value="HEAD"/>
 *     <enumeration value="HEADMEAT_CHEEKMEAT"/>
 *     <enumeration value="HEART"/>
 *     <enumeration value="HINDQUARTER"/>
 *     <enumeration value="HORN"/>
 *     <enumeration value="INTESTINE_LARGE"/>
 *     <enumeration value="INTESTINE_SMALL"/>
 *     <enumeration value="KIDNEY"/>
 *     <enumeration value="LIPS"/>
 *     <enumeration value="LIVER"/>
 *     <enumeration value="LUNGS"/>
 *     <enumeration value="MIXED_OFFAL"/>
 *     <enumeration value="MIXED_PARTS_FOR_GROUNDING_MINCING"/>
 *     <enumeration value="NECK"/>
 *     <enumeration value="PANCREAS"/>
 *     <enumeration value="SKIN"/>
 *     <enumeration value="STOMACH"/>
 *     <enumeration value="TAIL"/>
 *     <enumeration value="TENDONS"/>
 *     <enumeration value="TESTICLES"/>
 *     <enumeration value="THYMUS"/>
 *     <enumeration value="TONGUE"/>
 *     <enumeration value="TRIPE"/>
 *     <enumeration value="UNCLASSIFIED"/>
 *     <enumeration value="UNIDENTIFIED"/>
 *     <enumeration value="WHOLE_BIRD"/>
 *     <enumeration value="WHOLE_MUSCLE_NONPOULTRY_MEATPART_PIECE"/>
 *     <enumeration value="WHOLE_MUSCLE_POULTRY_PART"/>
 *     <enumeration value="WHOLE_MUSCLE_PRIMAL"/>
 *     <enumeration value="WHOLE_MUSCLE_RIBCUT"/>
 *     <enumeration value="WHOLE_MUSCLE_ROASTCUT"/>
 *     <enumeration value="WHOLE_MUSCLE_SLICE_CHOPCUT"/>
 *     <enumeration value="WHOLE_MUSCLE_SLICE_CUTLET"/>
 *     <enumeration value="WHOLE_MUSCLE_STEAK_CHOPCUT"/>
 *     <enumeration value="WHOLE_MUSCLE_SUBPRIMAL"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "AnatomicalFormCode")
@XmlEnum
public enum AnatomicalFormCode {

    BELLY,
    BLOOD,
    BONE,
    BRAIN,
    CARCASS_NONPOULTRY,
    DIAPHRAM,
    ESOPHAGUS,
    FAT,
    FEET,
    FOREQUARTER,
    GIZZARD,
    HEAD,
    HEADMEAT_CHEEKMEAT,
    HEART,
    HINDQUARTER,
    HORN,
    INTESTINE_LARGE,
    INTESTINE_SMALL,
    KIDNEY,
    LIPS,
    LIVER,
    LUNGS,
    MIXED_OFFAL,
    MIXED_PARTS_FOR_GROUNDING_MINCING,
    NECK,
    PANCREAS,
    SKIN,
    STOMACH,
    TAIL,
    TENDONS,
    TESTICLES,
    THYMUS,
    TONGUE,
    TRIPE,
    UNCLASSIFIED,
    UNIDENTIFIED,
    WHOLE_BIRD,
    WHOLE_MUSCLE_NONPOULTRY_MEATPART_PIECE,
    WHOLE_MUSCLE_POULTRY_PART,
    WHOLE_MUSCLE_PRIMAL,
    WHOLE_MUSCLE_RIBCUT,
    WHOLE_MUSCLE_ROASTCUT,
    WHOLE_MUSCLE_SLICE_CHOPCUT,
    WHOLE_MUSCLE_SLICE_CUTLET,
    WHOLE_MUSCLE_STEAK_CHOPCUT,
    WHOLE_MUSCLE_SUBPRIMAL;

    public String value() {
        return name();
    }

    public static AnatomicalFormCode fromValue(String v) {
        return valueOf(v);
    }

}