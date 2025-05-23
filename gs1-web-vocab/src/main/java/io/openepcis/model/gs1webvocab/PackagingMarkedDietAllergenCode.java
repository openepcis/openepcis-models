//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for PackagingMarkedDietAllergenCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="PackagingMarkedDietAllergenCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="APPROVED_BY_ASTHMA_AND_ALLERGY_ASSOC"/>
 *     <enumeration value="APPROVED_FOR_TUBE_FEEDING"/>
 *     <enumeration value="BIOLOGICAL"/>
 *     <enumeration value="CALORIES_PER_PORTION"/>
 *     <enumeration value="CONTAINS_LATEX"/>
 *     <enumeration value="CONTAINS_PVC"/>
 *     <enumeration value="CONTAINS_PVC_WITHOUT_PHTHALATES"/>
 *     <enumeration value="CONTAINS_PVC_WITH_PHTHALATES"/>
 *     <enumeration value="DIET_PRODUCT_450_800_KCAL_PER_DAY"/>
 *     <enumeration value="DIET_PRODUCT_800_1200_KCAL_PER_DAY"/>
 *     <enumeration value="GEZONDE_KEUZE_KLAVERTJE"/>
 *     <enumeration value="HALAL"/>
 *     <enumeration value="IK_KIES_BEWUST"/>
 *     <enumeration value="KOSHER"/>
 *     <enumeration value="LACTASE_ENZYME"/>
 *     <enumeration value="LOW_ON_PHENYLALANINE"/>
 *     <enumeration value="LOW_ON_SUGAR"/>
 *     <enumeration value="MOTHERS_MILK_SUBSTITUTE"/>
 *     <enumeration value="NUTRITION_SUPPLEMENT"/>
 *     <enumeration value="NYCKELHAL_MARK"/>
 *     <enumeration value="VEGETARIAN"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "PackagingMarkedDietAllergenCode")
@XmlEnum
public enum PackagingMarkedDietAllergenCode {
  APPROVED_BY_ASTHMA_AND_ALLERGY_ASSOC,
  APPROVED_FOR_TUBE_FEEDING,
  BIOLOGICAL,
  CALORIES_PER_PORTION,
  CONTAINS_LATEX,
  CONTAINS_PVC,
  CONTAINS_PVC_WITHOUT_PHTHALATES,
  CONTAINS_PVC_WITH_PHTHALATES,
  DIET_PRODUCT_450_800_KCAL_PER_DAY,
  DIET_PRODUCT_800_1200_KCAL_PER_DAY,
  GEZONDE_KEUZE_KLAVERTJE,
  HALAL,
  IK_KIES_BEWUST,
  KOSHER,
  LACTASE_ENZYME,
  LOW_ON_PHENYLALANINE,
  LOW_ON_SUGAR,
  MOTHERS_MILK_SUBSTITUTE,
  NUTRITION_SUPPLEMENT,
  NYCKELHAL_MARK,
  VEGETARIAN;

  public String value() {
    return name();
  }

  public static PackagingMarkedDietAllergenCode fromValue(String v) {
    return valueOf(v);
  }
}
