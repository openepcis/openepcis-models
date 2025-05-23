//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for PreservationTechniqueCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="PreservationTechniqueCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ACIDIFICATION"/>
 *     <enumeration value="ALCOHOL_CURING"/>
 *     <enumeration value="ATTESTED_MILK"/>
 *     <enumeration value="BOILING"/>
 *     <enumeration value="BRINING"/>
 *     <enumeration value="CANNING"/>
 *     <enumeration value="COLD_SMOKE_CURING"/>
 *     <enumeration value="CONSERVE"/>
 *     <enumeration value="DEHYDRATION"/>
 *     <enumeration value="DRYING"/>
 *     <enumeration value="FERMENTATION"/>
 *     <enumeration value="FREEZE_DRYING"/>
 *     <enumeration value="FREEZING"/>
 *     <enumeration value="HIGH_TEMPERATURE_TREATED_MILK"/>
 *     <enumeration value="HOT_SMOKE_CURING"/>
 *     <enumeration value="IONISATION"/>
 *     <enumeration value="IRRADIATION"/>
 *     <enumeration value="PASTEURISATION"/>
 *     <enumeration value="QUICK_FREEZING"/>
 *     <enumeration value="SALT_CURING"/>
 *     <enumeration value="SOUS_VIDE"/>
 *     <enumeration value="STERILISATION"/>
 *     <enumeration value="SUGAR_CURING"/>
 *     <enumeration value="ULTRA_HIGH_TEMPERATURE"/>
 *     <enumeration value="UNDER_MODIFIED_ATMOSPHERE"/>
 *     <enumeration value="VACUUM_PACKED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "PreservationTechniqueCode")
@XmlEnum
public enum PreservationTechniqueCode {
  ACIDIFICATION,
  ALCOHOL_CURING,
  ATTESTED_MILK,
  BOILING,
  BRINING,
  CANNING,
  COLD_SMOKE_CURING,
  CONSERVE,
  DEHYDRATION,
  DRYING,
  FERMENTATION,
  FREEZE_DRYING,
  FREEZING,
  HIGH_TEMPERATURE_TREATED_MILK,
  HOT_SMOKE_CURING,
  IONISATION,
  IRRADIATION,
  PASTEURISATION,
  QUICK_FREEZING,
  SALT_CURING,
  SOUS_VIDE,
  STERILISATION,
  SUGAR_CURING,
  ULTRA_HIGH_TEMPERATURE,
  UNDER_MODIFIED_ATMOSPHERE,
  VACUUM_PACKED;

  public String value() {
    return name();
  }

  public static PreservationTechniqueCode fromValue(String v) {
    return valueOf(v);
  }
}
