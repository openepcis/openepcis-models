package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface Product {
    AdditionalProductClassificationDetails getAdditionalProductClassification();

    void setAdditionalProductClassification(AdditionalProductClassificationDetails value);

    String getAdditionalProductDescription();

    void setAdditionalProductDescription(String value);

    AdditiveDetails getAdditive();

    void setAdditive(AdditiveDetails value);

    ReferencedFileDetails getAudioFile();

    void setAudioFile(ReferencedFileDetails value);

    AuthenticityDetails getAuthenticity();

    void setAuthenticity(AuthenticityDetails value);

    AwardPrizeDetails getAwardPrize();

    void setAwardPrize(AwardPrizeDetails value);

    String getBestBeforeDate();

    void setBestBeforeDate(String value);

    Brand getBrand();

    void setBrand(Brand value);

    OrganizationXMLImpl getBrandOwner();

    void setBrandOwner(OrganizationXMLImpl value);

    CertificationDetailsXMLImpl getCertification();

    void setCertification(CertificationDetailsXMLImpl value);

    ColourCodeDetails getColourCode();

    void setColourCode(ColourCodeDetails value);

    String getColourDescription();

    void setColourDescription(String value);

    ReferencedFileDetails getConsumerHandlingStorage();

    void setConsumerHandlingStorage(ReferencedFileDetails value);

    String getConsumerPackageDisclaimer();

    void setConsumerPackageDisclaimer(String value);

    String getConsumerProductVariant();

    void setConsumerProductVariant(String value);

    String getConsumerSafetyInformation();

    void setConsumerSafetyInformation(String value);

    ConsumerSalesConditionsCode getConsumerSalesCondition();

    void setConsumerSalesCondition(ConsumerSalesConditionsCode value);

    String getConsumerStorageInstructions();

    void setConsumerStorageInstructions(String value);

    String getConsumerUsageInstructions();

    void setConsumerUsageInstructions(String value);

    Country getCountryOfAssembly();

    void setCountryOfAssembly(Country value);

    Country getCountryOfLastProcessing();

    void setCountryOfLastProcessing(Country value);

    Country getCountryOfOrigin();

    void setCountryOfOrigin(Country value);

    String getCountryOfOriginStatement();

    void setCountryOfOriginStatement(String value);

    OrganizationXMLImpl getCustomerSupportCentre();

    void setCustomerSupportCentre(OrganizationXMLImpl value);

    ProductXMLImpl getDependentProprietaryProduct();

    void setDependentProprietaryProduct(ProductXMLImpl value);

    String getDescriptiveSize();

    void setDescriptiveSize(String value);

    String getDueDate();

    void setDueDate(String value);

    ProductXMLImpl getEquivalentProduct();

    void setEquivalentProduct(ProductXMLImpl value);

    String getExpirationDate();

    void setExpirationDate(String value);

    String getExpirationDateTime();

    void setExpirationDateTime(String value);

    String getFirstFreezeDate();

    void setFirstFreezeDate(String value);

    String getFunctionalName();

    void setFunctionalName(String value);

    String getGpcCategoryCode();

    void setGpcCategoryCode(String value);

    String getGpcCategoryDescription();

    void setGpcCategoryDescription(String value);

    QuantitativeValue getGrossArea();

    void setGrossArea(QuantitativeValue value);

    QuantitativeValue getGrossVolume();

    void setGrossVolume(QuantitativeValue value);

    QuantitativeValue getGrossWeight();

    void setGrossWeight(QuantitativeValue value);

    GrowingMethodCode getGrowingMethod();

    void setGrowingMethod(GrowingMethodCode value);

    String getGtin();

    void setGtin(String value);

    String getHarvestDate();

    void setHarvestDate(String value);

    String getHarvestDateEnd();

    void setHarvestDateEnd(String value);

    String getHarvestDateStart();

    void setHarvestDateStart(String value);

    String getHasBatchLotNumber();

    void setHasBatchLotNumber(String value);

    String getHasSerialNumber();

    void setHasSerialNumber(String value);

    String getHasThirdPartyControlledSerialNumber();

    void setHasThirdPartyControlledSerialNumber(String value);

    String getHealthClaimDescription();

    void setHealthClaimDescription(String value);

    ReferencedFileDetails getImage();

    void setImage(ReferencedFileDetails value);

    QuantitativeValue getInPackageDepth();

    void setInPackageDepth(QuantitativeValue value);

    QuantitativeValue getInPackageDiameter();

    void setInPackageDiameter(QuantitativeValue value);

    QuantitativeValue getInPackageHeight();

    void setInPackageHeight(QuantitativeValue value);

    QuantitativeValue getInPackageWidth();

    void setInPackageWidth(QuantitativeValue value);

    String getIncludedAccessories();

    void setIncludedAccessories(String value);

    ReferencedFileDetails getInstructionsForUse();

    void setInstructionsForUse(ReferencedFileDetails value);

    String getIsProductRecalled();

    void setIsProductRecalled(String value);

    String getJws();

    void setJws(String value);

    OrganizationXMLImpl getManufacturer();

    void setManufacturer(OrganizationXMLImpl value);

    WarrantyPromise getManufacturersWarranty();

    void setManufacturersWarranty(WarrantyPromise value);

    OrganizationXMLImpl getManufacturingPlant();

    void setManufacturingPlant(OrganizationXMLImpl value);

    QuantitativeValue getMassPerUnitArea();

    void setMassPerUnitArea(QuantitativeValue value);

    QuantitativeValue getNetArea();

    void setNetArea(QuantitativeValue value);

    QuantitativeValue getNetContent();

    void setNetContent(QuantitativeValue value);

    QuantitativeValue getNetWeight();

    void setNetWeight(QuantitativeValue value);

    OrganicClaimDetails getOrganicClaim();

    void setOrganicClaim(OrganicClaimDetails value);

    QuantitativeValue getOutOfPackageDepth();

    void setOutOfPackageDepth(QuantitativeValue value);

    QuantitativeValue getOutOfPackageDiameter();

    void setOutOfPackageDiameter(QuantitativeValue value);

    QuantitativeValue getOutOfPackageHeight();

    void setOutOfPackageHeight(QuantitativeValue value);

    QuantitativeValue getOutOfPackageWidth();

    void setOutOfPackageWidth(QuantitativeValue value);

    PackagingDetails getPackaging();

    void setPackaging(PackagingDetails value);

    String getPackagingDate();

    void setPackagingDate(String value);

    PackagingMarkedLabelAccreditationCode getPackagingMarkedLabelAccreditation();

    void setPackagingMarkedLabelAccreditation(PackagingMarkedLabelAccreditationCode value);

    ProductXMLImpl getPrimaryAlternateProduct();

    void setPrimaryAlternateProduct(ProductXMLImpl value);

    String getProductDescription();

    void setProductDescription(String value);

    String getProductFeatureBenefit();

    void setProductFeatureBenefit(String value);

    String getProductFormDescription();

    void setProductFormDescription(String value);

    String getProductID();

    void setProductID(String value);

    String getProductMarketingMessage();

    void setProductMarketingMessage(String value);

    String getProductName();

    void setProductName(String value);

    String getProductRange();

    void setProductRange(String value);

    String getProductSustainabilityInfo();

    void setProductSustainabilityInfo(String value);

    String getProductionDate();

    void setProductionDate(String value);

    String getProductionDateTime();

    void setProductionDateTime(String value);

    String getProductionVariantDescription();

    void setProductionVariantDescription(String value);

    String getProductionVariantEffectiveDateTime();

    void setProductionVariantEffectiveDateTime(String value);

    String getProvenanceStatement();

    void setProvenanceStatement(String value);

    ReferencedFileDetails getReferencedFile();

    void setReferencedFile(ReferencedFileDetails value);

    String getRegulatedProductName();

    void setRegulatedProductName(String value);

    ProductXMLImpl getReplacedByProduct();

    void setReplacedByProduct(ProductXMLImpl value);

    ProductXMLImpl getReplacedProduct();

    void setReplacedProduct(ProductXMLImpl value);

    String getSellByDate();

    void setSellByDate(String value);

    SizeCodeDetails getSizeCode();

    void setSizeCode(SizeCodeDetails value);

    String getSupplierSpecifiedMinimumConsumerStorageDays();

    void setSupplierSpecifiedMinimumConsumerStorageDays(String value);

    TargetMarketDetails getTargetMarket();

    void setTargetMarket(TargetMarketDetails value);

    String getVariantDescription();

    void setVariantDescription(String value);

    String getWarningCopyDescription();

    void setWarningCopyDescription(String value);
}
