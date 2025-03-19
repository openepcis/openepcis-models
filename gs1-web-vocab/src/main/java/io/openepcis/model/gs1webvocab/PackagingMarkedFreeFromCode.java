//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for PackagingMarkedFreeFromCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="PackagingMarkedFreeFromCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="FREE_FROM_ARTIFICIAL_COLOURING"/>
 *     <enumeration value="FREE_FROM_ARTIFICIAL_FLAVOURING"/>
 *     <enumeration value="FREE_FROM_ARTIFICIAL_PRESERVATIVES"/>
 *     <enumeration value="FREE_FROM_CHOLESTEROL"/>
 *     <enumeration value="FREE_FROM_CLONED_FOOD"/>
 *     <enumeration value="FREE_FROM_DAIRY"/>
 *     <enumeration value="FREE_FROM_EGG"/>
 *     <enumeration value="FREE_FROM_FISH"/>
 *     <enumeration value="FREE_FROM_GLUTEN"/>
 *     <enumeration value="FREE_FROM_LACTOSE"/>
 *     <enumeration value="FREE_FROM_LATEX"/>
 *     <enumeration value="FREE_FROM_LEGUME_PROTEIN"/>
 *     <enumeration value="FREE_FROM_MILK"/>
 *     <enumeration value="FREE_FROM_MILK_PROTEIN"/>
 *     <enumeration value="FREE_FROM_NATURAL_GLUTEN"/>
 *     <enumeration value="FREE_FROM_PEANUTS"/>
 *     <enumeration value="FREE_FROM_PROTEIN"/>
 *     <enumeration value="FREE_FROM_PVC"/>
 *     <enumeration value="FREE_FROM_SOYA"/>
 *     <enumeration value="FREE_FROM_SUGAR"/>
 *     <enumeration value="FREE_FROM_TRANSFAT"/>
 *     <enumeration value="REDUCED_LACTOSE"/>
 *     <enumeration value="REDUCED_PROTEIN"/>
 *     <enumeration value="REDUCED_TRANSFAT"/>
 *     <enumeration value="VERY_LOW_GLUTEN"/>
 *     <enumeration value="WITHOUT_ADDED_SALT"/>
 *     <enumeration value="WITHOUT_ADDED_SUGAR"/>
 *     <enumeration value="WITHOUT_ADDED_SWEETENER"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "PackagingMarkedFreeFromCode")
@XmlEnum
public enum PackagingMarkedFreeFromCode {
  FREE_FROM_ARTIFICIAL_COLOURING,
  FREE_FROM_ARTIFICIAL_FLAVOURING,
  FREE_FROM_ARTIFICIAL_PRESERVATIVES,
  FREE_FROM_CHOLESTEROL,
  FREE_FROM_CLONED_FOOD,
  FREE_FROM_DAIRY,
  FREE_FROM_EGG,
  FREE_FROM_FISH,
  FREE_FROM_GLUTEN,
  FREE_FROM_LACTOSE,
  FREE_FROM_LATEX,
  FREE_FROM_LEGUME_PROTEIN,
  FREE_FROM_MILK,
  FREE_FROM_MILK_PROTEIN,
  FREE_FROM_NATURAL_GLUTEN,
  FREE_FROM_PEANUTS,
  FREE_FROM_PROTEIN,
  FREE_FROM_PVC,
  FREE_FROM_SOYA,
  FREE_FROM_SUGAR,
  FREE_FROM_TRANSFAT,
  REDUCED_LACTOSE,
  REDUCED_PROTEIN,
  REDUCED_TRANSFAT,
  VERY_LOW_GLUTEN,
  WITHOUT_ADDED_SALT,
  WITHOUT_ADDED_SUGAR,
  WITHOUT_ADDED_SWEETENER;

  public String value() {
    return name();
  }

  public static PackagingMarkedFreeFromCode fromValue(String v) {
    return valueOf(v);
  }
}
