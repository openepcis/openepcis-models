//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for LocationRoleType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="LocationRoleType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AGED_CARE_SERVICE"/>
 *     <enumeration value="AIRCRAFT"/>
 *     <enumeration value="AIRPORT"/>
 *     <enumeration value="AIRPORT_GATE"/>
 *     <enumeration value="AMBULANCE_SERVICE"/>
 *     <enumeration value="AMUSEMENT_ENTERTAINMENT_GAMING"/>
 *     <enumeration value="ASSEMBLY"/>
 *     <enumeration value="ATM"/>
 *     <enumeration value="BACKROOM"/>
 *     <enumeration value="BANK"/>
 *     <enumeration value="BERTH"/>
 *     <enumeration value="BIRTH_AREA"/>
 *     <enumeration value="BOAT"/>
 *     <enumeration value="BOTTLING_SITE"/>
 *     <enumeration value="BOX_CRUSHER"/>
 *     <enumeration value="BRANCH_LOCATION"/>
 *     <enumeration value="CASH_CARRY_STORE"/>
 *     <enumeration value="CITY_CENTER_SHOP"/>
 *     <enumeration value="CLINIC"/>
 *     <enumeration value="CLINICAL_TRIAL_SITE"/>
 *     <enumeration value="COLLECTION_CENTER"/>
 *     <enumeration value="CONSOLIDATING_CENTER"/>
 *     <enumeration value="CONSTRUCTION_SITE"/>
 *     <enumeration value="CONTAINER_DECK"/>
 *     <enumeration value="CONTROLLED_SUBSTANCE_AREA"/>
 *     <enumeration value="CONVENIENCE_STORE"/>
 *     <enumeration value="CONVEYOR_BELT"/>
 *     <enumeration value="CORRECTION_FACILITY"/>
 *     <enumeration value="CUSTOMER_PICK-UP_AREA"/>
 *     <enumeration value="CUSTOMS_BORDER_CONTROL"/>
 *     <enumeration value="DENTAL_HEALTH_SERVICE"/>
 *     <enumeration value="DEPOT"/>
 *     <enumeration value="DISPENSER"/>
 *     <enumeration value="DISTRIBUTION_CENTER"/>
 *     <enumeration value="DOCK"/>
 *     <enumeration value="DOCTOR_OFFICE"/>
 *     <enumeration value="DRUG_STORE"/>
 *     <enumeration value="DUTY_FREE_STORE"/>
 *     <enumeration value="EARLY_CHILDHOOD_EDUCATING_AND_CENTER"/>
 *     <enumeration value="EDI_STATION"/>
 *     <enumeration value="EDUCATION_FACILITY"/>
 *     <enumeration value="ELECTRONICS_AREA"/>
 *     <enumeration value="EMERGENCY_DEPARTMENT_AREA"/>
 *     <enumeration value="END_CAP_AREA"/>
 *     <enumeration value="ENTRANCE_GATE"/>
 *     <enumeration value="EXIT_GATE"/>
 *     <enumeration value="FARM"/>
 *     <enumeration value="FEEDLOT_SITE"/>
 *     <enumeration value="FIELD"/>
 *     <enumeration value="FIXED_READER"/>
 *     <enumeration value="FIXED_TRANSPORT_FACILITIES"/>
 *     <enumeration value="FOOD_BUSINESS"/>
 *     <enumeration value="FREIGHT_HUB"/>
 *     <enumeration value="FREIGHT_TERMINAL"/>
 *     <enumeration value="GARDEN_CENTER"/>
 *     <enumeration value="GATE"/>
 *     <enumeration value="GENERAL_MDSE_AREA"/>
 *     <enumeration value="GOVERNMENT_DEPARTMENT_AGENCY"/>
 *     <enumeration value="GREENHOUSE"/>
 *     <enumeration value="GROCERY"/>
 *     <enumeration value="HANDLING_AREA"/>
 *     <enumeration value="HEAD_OFFICE"/>
 *     <enumeration value="HOSPITAL"/>
 *     <enumeration value="HOSPITAL_CAFETERIA"/>
 *     <enumeration value="HOSPITAL_DEPARTMENT"/>
 *     <enumeration value="HOSPITAL_PHARMACY"/>
 *     <enumeration value="IMAGING_DIAGNOSTICS_AREA"/>
 *     <enumeration value="IMPREST_LOCATION"/>
 *     <enumeration value="INLAND_FISHERY"/>
 *     <enumeration value="INLAND_PORT"/>
 *     <enumeration value="INTERMODAL_TERMINAL"/>
 *     <enumeration value="INTERNATIONAL_MAIL_PROCESSING_CENTER"/>
 *     <enumeration value="LANE_OR_ROUTE"/>
 *     <enumeration value="LAY-AWAY"/>
 *     <enumeration value="LIBRARY"/>
 *     <enumeration value="MAIN_RECEPTION"/>
 *     <enumeration value="MANUFACTURING_PLANT"/>
 *     <enumeration value="MARINE_FISHERY"/>
 *     <enumeration value="MARKET"/>
 *     <enumeration value="MENTAL_HEALTH_SERVICE"/>
 *     <enumeration value="MILKING_SITE"/>
 *     <enumeration value="MOBILE_READER"/>
 *     <enumeration value="NURSE_STATION"/>
 *     <enumeration value="OFFICE"/>
 *     <enumeration value="ONLINE_PLATFORM"/>
 *     <enumeration value="ONLINE_SHOP"/>
 *     <enumeration value="OPERATING_THEATER"/>
 *     <enumeration value="PACKAGING_AREA"/>
 *     <enumeration value="PACKHOUSE"/>
 *     <enumeration value="PALLET_WRAPPER"/>
 *     <enumeration value="PATHOLOGY"/>
 *     <enumeration value="PERSONAL_SERVICES"/>
 *     <enumeration value="PETROL_STATION"/>
 *     <enumeration value="PICK-UP_LOCATION"/>
 *     <enumeration value="PICKING_AREA"/>
 *     <enumeration value="POINT_OF_SALE"/>
 *     <enumeration value="PRIMARY_HEALTH_SERVICE"/>
 *     <enumeration value="PRINTING_ROOM"/>
 *     <enumeration value="PRODUCTION_AREA"/>
 *     <enumeration value="PRODUCTION_LINE"/>
 *     <enumeration value="PROMOTION_AREA"/>
 *     <enumeration value="PUBLIC_WAREHOUSE"/>
 *     <enumeration value="QUALITY_CONTROL"/>
 *     <enumeration value="QUARANTINE"/>
 *     <enumeration value="RAIL_STATION"/>
 *     <enumeration value="RAIL_TERMINAL"/>
 *     <enumeration value="READ_POINT_VERIFICATION_SPOT"/>
 *     <enumeration value="REARING_AREA"/>
 *     <enumeration value="RECALLED_PRODUCT_AREA"/>
 *     <enumeration value="RECEIVING_AREA"/>
 *     <enumeration value="RECEIVING_LOCATION"/>
 *     <enumeration value="REPACKING_FACILITY"/>
 *     <enumeration value="RESEARCH_FACILITY"/>
 *     <enumeration value="RESIDENCE"/>
 *     <enumeration value="RETAIL_PHARMACY"/>
 *     <enumeration value="RETURNABLE_ASSET_SERVICE_CENTER"/>
 *     <enumeration value="RETURNS_AREA"/>
 *     <enumeration value="ROAD_TERMINAL"/>
 *     <enumeration value="SALES_FLOOR"/>
 *     <enumeration value="SALES_FLOOR_TRANSITION_AREA"/>
 *     <enumeration value="SALES_YARD"/>
 *     <enumeration value="SEAPORT"/>
 *     <enumeration value="SECURITY_AREA"/>
 *     <enumeration value="SELF_SERVICE"/>
 *     <enumeration value="SERVICE_COUNTER"/>
 *     <enumeration value="SHELF"/>
 *     <enumeration value="SHIPPING_AREA"/>
 *     <enumeration value="SHIP_FROM_LOCATION"/>
 *     <enumeration value="SHIP_TO_LOCATION"/>
 *     <enumeration value="SILO"/>
 *     <enumeration value="SLAUGHTER_HOUSE"/>
 *     <enumeration value="SPORTS_AND_RECERATIONAL"/>
 *     <enumeration value="STAGING_AREA"/>
 *     <enumeration value="STATION"/>
 *     <enumeration value="STORAGE_AREA"/>
 *     <enumeration value="STORE"/>
 *     <enumeration value="TERMINAL"/>
 *     <enumeration value="TRADE_ITEM_RETURN_LOCATION"/>
 *     <enumeration value="TRAIN"/>
 *     <enumeration value="VENDING"/>
 *     <enumeration value="VENDOR_LEASED_SPACE"/>
 *     <enumeration value="VINEYARD"/>
 *     <enumeration value="VISITING_ADDRESS"/>
 *     <enumeration value="WARD"/>
 *     <enumeration value="WAREHOUSE"/>
 *     <enumeration value="WASTE_CENTER"/>
 *     <enumeration value="WHARF"/>
 *     <enumeration value="YARD"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "LocationRoleType")
@XmlEnum
public enum LocationRoleType {

    AGED_CARE_SERVICE("AGED_CARE_SERVICE"),
    AIRCRAFT("AIRCRAFT"),
    AIRPORT("AIRPORT"),
    AIRPORT_GATE("AIRPORT_GATE"),
    AMBULANCE_SERVICE("AMBULANCE_SERVICE"),
    AMUSEMENT_ENTERTAINMENT_GAMING("AMUSEMENT_ENTERTAINMENT_GAMING"),
    ASSEMBLY("ASSEMBLY"),
    ATM("ATM"),
    BACKROOM("BACKROOM"),
    BANK("BANK"),
    BERTH("BERTH"),
    BIRTH_AREA("BIRTH_AREA"),
    BOAT("BOAT"),
    BOTTLING_SITE("BOTTLING_SITE"),
    BOX_CRUSHER("BOX_CRUSHER"),
    BRANCH_LOCATION("BRANCH_LOCATION"),
    CASH_CARRY_STORE("CASH_CARRY_STORE"),
    CITY_CENTER_SHOP("CITY_CENTER_SHOP"),
    CLINIC("CLINIC"),
    CLINICAL_TRIAL_SITE("CLINICAL_TRIAL_SITE"),
    COLLECTION_CENTER("COLLECTION_CENTER"),
    CONSOLIDATING_CENTER("CONSOLIDATING_CENTER"),
    CONSTRUCTION_SITE("CONSTRUCTION_SITE"),
    CONTAINER_DECK("CONTAINER_DECK"),
    CONTROLLED_SUBSTANCE_AREA("CONTROLLED_SUBSTANCE_AREA"),
    CONVENIENCE_STORE("CONVENIENCE_STORE"),
    CONVEYOR_BELT("CONVEYOR_BELT"),
    CORRECTION_FACILITY("CORRECTION_FACILITY"),
    @XmlEnumValue("CUSTOMER_PICK-UP_AREA")
    CUSTOMER_PICK_UP_AREA("CUSTOMER_PICK-UP_AREA"),
    CUSTOMS_BORDER_CONTROL("CUSTOMS_BORDER_CONTROL"),
    DENTAL_HEALTH_SERVICE("DENTAL_HEALTH_SERVICE"),
    DEPOT("DEPOT"),
    DISPENSER("DISPENSER"),
    DISTRIBUTION_CENTER("DISTRIBUTION_CENTER"),
    DOCK("DOCK"),
    DOCTOR_OFFICE("DOCTOR_OFFICE"),
    DRUG_STORE("DRUG_STORE"),
    DUTY_FREE_STORE("DUTY_FREE_STORE"),
    EARLY_CHILDHOOD_EDUCATING_AND_CENTER("EARLY_CHILDHOOD_EDUCATING_AND_CENTER"),
    EDI_STATION("EDI_STATION"),
    EDUCATION_FACILITY("EDUCATION_FACILITY"),
    ELECTRONICS_AREA("ELECTRONICS_AREA"),
    EMERGENCY_DEPARTMENT_AREA("EMERGENCY_DEPARTMENT_AREA"),
    END_CAP_AREA("END_CAP_AREA"),
    ENTRANCE_GATE("ENTRANCE_GATE"),
    EXIT_GATE("EXIT_GATE"),
    FARM("FARM"),
    FEEDLOT_SITE("FEEDLOT_SITE"),
    FIELD("FIELD"),
    FIXED_READER("FIXED_READER"),
    FIXED_TRANSPORT_FACILITIES("FIXED_TRANSPORT_FACILITIES"),
    FOOD_BUSINESS("FOOD_BUSINESS"),
    FREIGHT_HUB("FREIGHT_HUB"),
    FREIGHT_TERMINAL("FREIGHT_TERMINAL"),
    GARDEN_CENTER("GARDEN_CENTER"),
    GATE("GATE"),
    GENERAL_MDSE_AREA("GENERAL_MDSE_AREA"),
    GOVERNMENT_DEPARTMENT_AGENCY("GOVERNMENT_DEPARTMENT_AGENCY"),
    GREENHOUSE("GREENHOUSE"),
    GROCERY("GROCERY"),
    HANDLING_AREA("HANDLING_AREA"),
    HEAD_OFFICE("HEAD_OFFICE"),
    HOSPITAL("HOSPITAL"),
    HOSPITAL_CAFETERIA("HOSPITAL_CAFETERIA"),
    HOSPITAL_DEPARTMENT("HOSPITAL_DEPARTMENT"),
    HOSPITAL_PHARMACY("HOSPITAL_PHARMACY"),
    IMAGING_DIAGNOSTICS_AREA("IMAGING_DIAGNOSTICS_AREA"),
    IMPREST_LOCATION("IMPREST_LOCATION"),
    INLAND_FISHERY("INLAND_FISHERY"),
    INLAND_PORT("INLAND_PORT"),
    INTERMODAL_TERMINAL("INTERMODAL_TERMINAL"),
    INTERNATIONAL_MAIL_PROCESSING_CENTER("INTERNATIONAL_MAIL_PROCESSING_CENTER"),
    LANE_OR_ROUTE("LANE_OR_ROUTE"),
    @XmlEnumValue("LAY-AWAY")
    LAY_AWAY("LAY-AWAY"),
    LIBRARY("LIBRARY"),
    MAIN_RECEPTION("MAIN_RECEPTION"),
    MANUFACTURING_PLANT("MANUFACTURING_PLANT"),
    MARINE_FISHERY("MARINE_FISHERY"),
    MARKET("MARKET"),
    MENTAL_HEALTH_SERVICE("MENTAL_HEALTH_SERVICE"),
    MILKING_SITE("MILKING_SITE"),
    MOBILE_READER("MOBILE_READER"),
    NURSE_STATION("NURSE_STATION"),
    OFFICE("OFFICE"),
    ONLINE_PLATFORM("ONLINE_PLATFORM"),
    ONLINE_SHOP("ONLINE_SHOP"),
    OPERATING_THEATER("OPERATING_THEATER"),
    PACKAGING_AREA("PACKAGING_AREA"),
    PACKHOUSE("PACKHOUSE"),
    PALLET_WRAPPER("PALLET_WRAPPER"),
    PATHOLOGY("PATHOLOGY"),
    PERSONAL_SERVICES("PERSONAL_SERVICES"),
    PETROL_STATION("PETROL_STATION"),
    @XmlEnumValue("PICK-UP_LOCATION")
    PICK_UP_LOCATION("PICK-UP_LOCATION"),
    PICKING_AREA("PICKING_AREA"),
    POINT_OF_SALE("POINT_OF_SALE"),
    PRIMARY_HEALTH_SERVICE("PRIMARY_HEALTH_SERVICE"),
    PRINTING_ROOM("PRINTING_ROOM"),
    PRODUCTION_AREA("PRODUCTION_AREA"),
    PRODUCTION_LINE("PRODUCTION_LINE"),
    PROMOTION_AREA("PROMOTION_AREA"),
    PUBLIC_WAREHOUSE("PUBLIC_WAREHOUSE"),
    QUALITY_CONTROL("QUALITY_CONTROL"),
    QUARANTINE("QUARANTINE"),
    RAIL_STATION("RAIL_STATION"),
    RAIL_TERMINAL("RAIL_TERMINAL"),
    READ_POINT_VERIFICATION_SPOT("READ_POINT_VERIFICATION_SPOT"),
    REARING_AREA("REARING_AREA"),
    RECALLED_PRODUCT_AREA("RECALLED_PRODUCT_AREA"),
    RECEIVING_AREA("RECEIVING_AREA"),
    RECEIVING_LOCATION("RECEIVING_LOCATION"),
    REPACKING_FACILITY("REPACKING_FACILITY"),
    RESEARCH_FACILITY("RESEARCH_FACILITY"),
    RESIDENCE("RESIDENCE"),
    RETAIL_PHARMACY("RETAIL_PHARMACY"),
    RETURNABLE_ASSET_SERVICE_CENTER("RETURNABLE_ASSET_SERVICE_CENTER"),
    RETURNS_AREA("RETURNS_AREA"),
    ROAD_TERMINAL("ROAD_TERMINAL"),
    SALES_FLOOR("SALES_FLOOR"),
    SALES_FLOOR_TRANSITION_AREA("SALES_FLOOR_TRANSITION_AREA"),
    SALES_YARD("SALES_YARD"),
    SEAPORT("SEAPORT"),
    SECURITY_AREA("SECURITY_AREA"),
    SELF_SERVICE("SELF_SERVICE"),
    SERVICE_COUNTER("SERVICE_COUNTER"),
    SHELF("SHELF"),
    SHIPPING_AREA("SHIPPING_AREA"),
    SHIP_FROM_LOCATION("SHIP_FROM_LOCATION"),
    SHIP_TO_LOCATION("SHIP_TO_LOCATION"),
    SILO("SILO"),
    SLAUGHTER_HOUSE("SLAUGHTER_HOUSE"),
    SPORTS_AND_RECERATIONAL("SPORTS_AND_RECERATIONAL"),
    STAGING_AREA("STAGING_AREA"),
    STATION("STATION"),
    STORAGE_AREA("STORAGE_AREA"),
    STORE("STORE"),
    TERMINAL("TERMINAL"),
    TRADE_ITEM_RETURN_LOCATION("TRADE_ITEM_RETURN_LOCATION"),
    TRAIN("TRAIN"),
    VENDING("VENDING"),
    VENDOR_LEASED_SPACE("VENDOR_LEASED_SPACE"),
    VINEYARD("VINEYARD"),
    VISITING_ADDRESS("VISITING_ADDRESS"),
    WARD("WARD"),
    WAREHOUSE("WAREHOUSE"),
    WASTE_CENTER("WASTE_CENTER"),
    WHARF("WHARF"),
    YARD("YARD");
    private final String value;

    LocationRoleType(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static LocationRoleType fromValue(String v) {
        for (LocationRoleType c: LocationRoleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
