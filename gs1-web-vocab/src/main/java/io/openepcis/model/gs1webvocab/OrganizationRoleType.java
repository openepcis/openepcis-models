//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for OrganizationRoleType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="OrganizationRoleType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ACCEPTING_PARTY"/>
 *     <enumeration value="ACCOUNTS_DEPARTMENT"/>
 *     <enumeration value="AGRICULTURAL_COOPERATIVE"/>
 *     <enumeration value="AIRPORT_OPERATOR"/>
 *     <enumeration value="AREA_HEALTH_SERVICE"/>
 *     <enumeration value="ARRIVING_GOODS_PARTY"/>
 *     <enumeration value="BILL_OF_LADING_RECIPIENT"/>
 *     <enumeration value="BILL_TO"/>
 *     <enumeration value="BRANCH"/>
 *     <enumeration value="BRAND_OWNER"/>
 *     <enumeration value="BREEDER"/>
 *     <enumeration value="BROKER_AGENT"/>
 *     <enumeration value="BUYER"/>
 *     <enumeration value="BUYERS_AGENT_REPRESENTATIVE"/>
 *     <enumeration value="BUYING_DEPARTMENT"/>
 *     <enumeration value="CARRIER"/>
 *     <enumeration value="CENTRAL_PAYMENT_SERVICE"/>
 *     <enumeration value="CHECKING_PARTY"/>
 *     <enumeration value="CHECK_ORDER"/>
 *     <enumeration value="CLINICAL_TRIAL_SPONSOR"/>
 *     <enumeration value="COMPLIANCE_AUTHORITY_OR_AGENCY"/>
 *     <enumeration value="CONFORMITY_ASSESSMENT_BODY"/>
 *     <enumeration value="CONSIGNEE"/>
 *     <enumeration value="CONSIGNOR"/>
 *     <enumeration value="CONSOLIDATOR"/>
 *     <enumeration value="CONSUMER"/>
 *     <enumeration value="CORPORATE_IDENTITY"/>
 *     <enumeration value="COUNTRY_ORGANIZATION"/>
 *     <enumeration value="CUSTOMS"/>
 *     <enumeration value="CUSTOMS_AUTHORITY"/>
 *     <enumeration value="CUSTOMS_BROKER"/>
 *     <enumeration value="CUTTER"/>
 *     <enumeration value="DATA_CONSUMER"/>
 *     <enumeration value="DATA_PROVIDER"/>
 *     <enumeration value="DECLARANTS_AGENT_REPRESENTATIVE"/>
 *     <enumeration value="DELIVERY_PARTY"/>
 *     <enumeration value="DELIVERY_RECIPIENT_PARTY"/>
 *     <enumeration value="DESIGNER"/>
 *     <enumeration value="DESPATCH_PARTY"/>
 *     <enumeration value="DISPATCH_PARTY"/>
 *     <enumeration value="DISTRIBUTION_MANAGEMENT_ENTITY_PROVIDER"/>
 *     <enumeration value="DISTRIBUTOR"/>
 *     <enumeration value="DOCK_DOOR"/>
 *     <enumeration value="EMERGENCY_DEPARTMENT"/>
 *     <enumeration value="EMPTY_EQUIPMENT_DISPATCH_PARTY"/>
 *     <enumeration value="EMPTY_EQUIPMENT_RETURN_PARTY"/>
 *     <enumeration value="EQUIPMENT_OWNER"/>
 *     <enumeration value="EXPORTER"/>
 *     <enumeration value="E_TAILER"/>
 *     <enumeration value="FACILITIES_MAINTENANCE_DEPARTMENT"/>
 *     <enumeration value="FACTOR"/>
 *     <enumeration value="FARM_OPERATOR"/>
 *     <enumeration value="FATTENER"/>
 *     <enumeration value="FISHING_OPERATOR"/>
 *     <enumeration value="FOODSERVICE_DISTRIBUTOR"/>
 *     <enumeration value="FOODSERVICE_OPERATOR"/>
 *     <enumeration value="FREIGHT_FORWARDER"/>
 *     <enumeration value="GOODS_OWNER"/>
 *     <enumeration value="GOVERNMENT_AGENCY"/>
 *     <enumeration value="GOVERNMENT_DEPARTMENT_OR_MINISTRY"/>
 *     <enumeration value="GROWER"/>
 *     <enumeration value="HARVESTER"/>
 *     <enumeration value="HEALTHCARE_PROVIDER"/>
 *     <enumeration value="HOSPITAL_ORGANIZATION"/>
 *     <enumeration value="HOSPITAL_PHARMACY_OPERATOR"/>
 *     <enumeration value="IMPORTER"/>
 *     <enumeration value="INFORMATION_PROVIDER"/>
 *     <enumeration value="INSURER"/>
 *     <enumeration value="INTERMEDIARY_BANK"/>
 *     <enumeration value="INTERMEDIARY_BANK_1"/>
 *     <enumeration value="INTERMEDIARY_BANK_2"/>
 *     <enumeration value="INVENTORY_CONTROLLER"/>
 *     <enumeration value="INVENTORY_REPORTING_PARTY"/>
 *     <enumeration value="INVOICEE"/>
 *     <enumeration value="ISSUER_OF_INVOICE"/>
 *     <enumeration value="LOGISTICS_SERVICE_PROVIDER"/>
 *     <enumeration value="MANUFACTURER_OF_FINISHED_GOODS"/>
 *     <enumeration value="MANUFACTURER_OF_GOODS"/>
 *     <enumeration value="MANUFACTURER_OF_UNFINISHED_GOODS"/>
 *     <enumeration value="MARKETING_DEPARTMENT"/>
 *     <enumeration value="MARKETPLACE_OPERATOR"/>
 *     <enumeration value="MARK_FOR"/>
 *     <enumeration value="MENTAL_HEALTH_SERVICE"/>
 *     <enumeration value="MESSAGE_FROM"/>
 *     <enumeration value="MESSAGE_RECIPIENT"/>
 *     <enumeration value="MINCER"/>
 *     <enumeration value="OPERATING_DIVISION"/>
 *     <enumeration value="OPERATOR"/>
 *     <enumeration value="ORDERING_PARTY"/>
 *     <enumeration value="OWNER_OF_EQUIPMENT"/>
 *     <enumeration value="OWNER_OF_MEANS_OF_TRANSPORT"/>
 *     <enumeration value="PACKER"/>
 *     <enumeration value="PARTY_DECLARING_THE_VALUE_ADDED_TAX"/>
 *     <enumeration value="PARTY_FOR_WHOM_ITEM_IS_ULTIMATELY_INTENDED"/>
 *     <enumeration value="PARTY_RECEIVING_PRIVATE_DATA"/>
 *     <enumeration value="PARTY_RECOVERING_THE_VALUE_ADDED_TAX"/>
 *     <enumeration value="PARTY_TO_RECEIVE_ALL_DOCUMENTS"/>
 *     <enumeration value="PARTY_TO_RECEIVE_COMMERCIAL_INVOICE"/>
 *     <enumeration value="PARTY_TO_RECEIVE_ELECTRONIC_MEMO_OF_INVOICE"/>
 *     <enumeration value="PARTY_TO_RECEIVE_FREIGHT_BILL"/>
 *     <enumeration value="PARTY_TO_RECEIVE_REFUND"/>
 *     <enumeration value="PAYEE"/>
 *     <enumeration value="PAYER"/>
 *     <enumeration value="PHARMACY_OPERATOR"/>
 *     <enumeration value="PORT_OPERATOR"/>
 *     <enumeration value="PRICE_LOCATION_PARTY"/>
 *     <enumeration value="PROXY"/>
 *     <enumeration value="PURCHASE_ORDER_RECEIVER"/>
 *     <enumeration value="RECALL_RECIPIENT"/>
 *     <enumeration value="RECALL_SPONSOR"/>
 *     <enumeration value="REGIONAL_ORGANIZATION"/>
 *     <enumeration value="REGISTERED_AGENT"/>
 *     <enumeration value="REMIT_TO"/>
 *     <enumeration value="REPACKER"/>
 *     <enumeration value="RETAILER"/>
 *     <enumeration value="RETAIL_PHARMACY_OPERATOR"/>
 *     <enumeration value="SALES_DEPARTMENT"/>
 *     <enumeration value="SELLER"/>
 *     <enumeration value="SERVICE_PROVIDER"/>
 *     <enumeration value="SHIPPER"/>
 *     <enumeration value="SHIP_FROM"/>
 *     <enumeration value="SHIP_FROM_PARTY"/>
 *     <enumeration value="SHIP_TO"/>
 *     <enumeration value="SHIP_TO_PARTY"/>
 *     <enumeration value="SLAUGHTERER"/>
 *     <enumeration value="STORAGE_AND_HANDLING"/>
 *     <enumeration value="STORAGE_AND_HANDLING_PARTY"/>
 *     <enumeration value="SUBSTITUTE_SUPPLIER"/>
 *     <enumeration value="SUPPLIER"/>
 *     <enumeration value="SUPPLY_CHAIN"/>
 *     <enumeration value="TECHNICAL_SUPPORT_DEPARTMENT"/>
 *     <enumeration value="TRADER"/>
 *     <enumeration value="TRADER_FINANCIAL"/>
 *     <enumeration value="TRADER_GOODS"/>
 *     <enumeration value="TRANSPORTATION_CARRIER"/>
 *     <enumeration value="WAREHOUSE_KEEPER"/>
 *     <enumeration value="WHOLESALER"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "OrganizationRoleType")
@XmlEnum
public enum OrganizationRoleType {
  ACCEPTING_PARTY,
  ACCOUNTS_DEPARTMENT,
  AGRICULTURAL_COOPERATIVE,
  AIRPORT_OPERATOR,
  AREA_HEALTH_SERVICE,
  ARRIVING_GOODS_PARTY,
  BILL_OF_LADING_RECIPIENT,
  BILL_TO,
  BRANCH,
  BRAND_OWNER,
  BREEDER,
  BROKER_AGENT,
  BUYER,
  BUYERS_AGENT_REPRESENTATIVE,
  BUYING_DEPARTMENT,
  CARRIER,
  CENTRAL_PAYMENT_SERVICE,
  CHECKING_PARTY,
  CHECK_ORDER,
  CLINICAL_TRIAL_SPONSOR,
  COMPLIANCE_AUTHORITY_OR_AGENCY,
  CONFORMITY_ASSESSMENT_BODY,
  CONSIGNEE,
  CONSIGNOR,
  CONSOLIDATOR,
  CONSUMER,
  CORPORATE_IDENTITY,
  COUNTRY_ORGANIZATION,
  CUSTOMS,
  CUSTOMS_AUTHORITY,
  CUSTOMS_BROKER,
  CUTTER,
  DATA_CONSUMER,
  DATA_PROVIDER,
  DECLARANTS_AGENT_REPRESENTATIVE,
  DELIVERY_PARTY,
  DELIVERY_RECIPIENT_PARTY,
  DESIGNER,
  DESPATCH_PARTY,
  DISPATCH_PARTY,
  DISTRIBUTION_MANAGEMENT_ENTITY_PROVIDER,
  DISTRIBUTOR,
  DOCK_DOOR,
  EMERGENCY_DEPARTMENT,
  EMPTY_EQUIPMENT_DISPATCH_PARTY,
  EMPTY_EQUIPMENT_RETURN_PARTY,
  EQUIPMENT_OWNER,
  EXPORTER,
  E_TAILER,
  FACILITIES_MAINTENANCE_DEPARTMENT,
  FACTOR,
  FARM_OPERATOR,
  FATTENER,
  FISHING_OPERATOR,
  FOODSERVICE_DISTRIBUTOR,
  FOODSERVICE_OPERATOR,
  FREIGHT_FORWARDER,
  GOODS_OWNER,
  GOVERNMENT_AGENCY,
  GOVERNMENT_DEPARTMENT_OR_MINISTRY,
  GROWER,
  HARVESTER,
  HEALTHCARE_PROVIDER,
  HOSPITAL_ORGANIZATION,
  HOSPITAL_PHARMACY_OPERATOR,
  IMPORTER,
  INFORMATION_PROVIDER,
  INSURER,
  INTERMEDIARY_BANK,
  INTERMEDIARY_BANK_1,
  INTERMEDIARY_BANK_2,
  INVENTORY_CONTROLLER,
  INVENTORY_REPORTING_PARTY,
  INVOICEE,
  ISSUER_OF_INVOICE,
  LOGISTICS_SERVICE_PROVIDER,
  MANUFACTURER_OF_FINISHED_GOODS,
  MANUFACTURER_OF_GOODS,
  MANUFACTURER_OF_UNFINISHED_GOODS,
  MARKETING_DEPARTMENT,
  MARKETPLACE_OPERATOR,
  MARK_FOR,
  MENTAL_HEALTH_SERVICE,
  MESSAGE_FROM,
  MESSAGE_RECIPIENT,
  MINCER,
  OPERATING_DIVISION,
  OPERATOR,
  ORDERING_PARTY,
  OWNER_OF_EQUIPMENT,
  OWNER_OF_MEANS_OF_TRANSPORT,
  PACKER,
  PARTY_DECLARING_THE_VALUE_ADDED_TAX,
  PARTY_FOR_WHOM_ITEM_IS_ULTIMATELY_INTENDED,
  PARTY_RECEIVING_PRIVATE_DATA,
  PARTY_RECOVERING_THE_VALUE_ADDED_TAX,
  PARTY_TO_RECEIVE_ALL_DOCUMENTS,
  PARTY_TO_RECEIVE_COMMERCIAL_INVOICE,
  PARTY_TO_RECEIVE_ELECTRONIC_MEMO_OF_INVOICE,
  PARTY_TO_RECEIVE_FREIGHT_BILL,
  PARTY_TO_RECEIVE_REFUND,
  PAYEE,
  PAYER,
  PHARMACY_OPERATOR,
  PORT_OPERATOR,
  PRICE_LOCATION_PARTY,
  PROXY,
  PURCHASE_ORDER_RECEIVER,
  RECALL_RECIPIENT,
  RECALL_SPONSOR,
  REGIONAL_ORGANIZATION,
  REGISTERED_AGENT,
  REMIT_TO,
  REPACKER,
  RETAILER,
  RETAIL_PHARMACY_OPERATOR,
  SALES_DEPARTMENT,
  SELLER,
  SERVICE_PROVIDER,
  SHIPPER,
  SHIP_FROM,
  SHIP_FROM_PARTY,
  SHIP_TO,
  SHIP_TO_PARTY,
  SLAUGHTERER,
  STORAGE_AND_HANDLING,
  STORAGE_AND_HANDLING_PARTY,
  SUBSTITUTE_SUPPLIER,
  SUPPLIER,
  SUPPLY_CHAIN,
  TECHNICAL_SUPPORT_DEPARTMENT,
  TRADER,
  TRADER_FINANCIAL,
  TRADER_GOODS,
  TRANSPORTATION_CARRIER,
  WAREHOUSE_KEEPER,
  WHOLESALER;

  public String value() {
    return name();
  }

  public static OrganizationRoleType fromValue(String v) {
    return valueOf(v);
  }
}
