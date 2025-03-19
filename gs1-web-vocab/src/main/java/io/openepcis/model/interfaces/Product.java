package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface Product<
    AP extends AdditionalProductClassificationDetails,
    AD extends AdditiveDetails,
    RF extends ReferencedFileDetails,
    AU extends AuthenticityDetails,
    AW extends AwardPrizeDetails,
    B extends Brand,
    O extends Organization,
    CD extends CertificationDetails,
    CC extends ColourCodeDetails,
    C extends Country,
    P extends Product,
    QV extends QuantitativeValue,
    WP extends WarrantyPromise,
    OC extends OrganicClaimDetails,
    PD extends PackagingDetails,
    SC extends SizeCodeDetails,
    TM extends TargetMarketDetails> {
  List<AP> getAdditionalProductClassification();

  void setAdditionalProductClassification(List<AP> value);

  String getAdditionalProductDescription();

  void setAdditionalProductDescription(String value);

  List<AD> getAdditive();

  void setAdditive(List<AD> value);

  RF getAudioFile();

  void setAudioFile(RF value);

  AU getAuthenticity();

  void setAuthenticity(AU value);

  List<AW> getAwardPrize();

  void setAwardPrize(List<AW> value);

  LocalDate getBestBeforeDate();

  void setBestBeforeDate(LocalDate value);

  B getBrand();

  void setBrand(B value);

  O getBrandOwner();

  void setBrandOwner(O value);

  List<CD> getCertification();

  void setCertification(List<CD> value);

  List<CC> getColourCode();

  void setColourCode(List<CC> value);

  String getColourDescription();

  void setColourDescription(String value);

  RF getConsumerHandlingStorage();

  void setConsumerHandlingStorage(RF value);

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

  C getCountryOfAssembly();

  void setCountryOfAssembly(C value);

  C getCountryOfLastProcessing();

  void setCountryOfLastProcessing(C value);

  C getCountryOfOrigin();

  void setCountryOfOrigin(C value);

  String getCountryOfOriginStatement();

  void setCountryOfOriginStatement(String value);

  O getCustomerSupportCentre();

  void setCustomerSupportCentre(O value);

  List<P> getDependentProprietaryProduct();

  void setDependentProprietaryProduct(List<P> value);

  String getDescriptiveSize();

  void setDescriptiveSize(String value);

  LocalDate getDueDate();

  void setDueDate(LocalDate value);

  List<P> getEquivalentProduct();

  void setEquivalentProduct(List<P> value);

  LocalDate getExpirationDate();

  void setExpirationDate(LocalDate value);

  LocalDate getExpirationDateTime();

  void setExpirationDateTime(LocalDate value);

  LocalDate getFirstFreezeDate();

  void setFirstFreezeDate(LocalDate value);

  String getFunctionalName();

  void setFunctionalName(String value);

  String getGpcCategoryCode();

  void setGpcCategoryCode(String value);

  String getGpcCategoryDescription();

  void setGpcCategoryDescription(String value);

  QV getGrossArea();

  void setGrossArea(QV value);

  QV getGrossVolume();

  void setGrossVolume(QV value);

  QV getGrossWeight();

  void setGrossWeight(QV value);

  GrowingMethodCode getGrowingMethod();

  void setGrowingMethod(GrowingMethodCode value);

  String getGtin();

  void setGtin(String value);

  LocalDate getHarvestDate();

  void setHarvestDate(LocalDate value);

  LocalDate getHarvestDateEnd();

  void setHarvestDateEnd(LocalDate value);

  LocalDate getHarvestDateStart();

  void setHarvestDateStart(LocalDate value);

  String getHasBatchLotNumber();

  void setHasBatchLotNumber(String value);

  String getHasSerialNumber();

  void setHasSerialNumber(String value);

  String getHasThirdPartyControlledSerialNumber();

  void setHasThirdPartyControlledSerialNumber(String value);

  String getHealthClaimDescription();

  void setHealthClaimDescription(String value);

  RF getImage();

  void setImage(RF value);

  QV getInPackageDepth();

  void setInPackageDepth(QV value);

  QV getInPackageDiameter();

  void setInPackageDiameter(QV value);

  QV getInPackageHeight();

  void setInPackageHeight(QV value);

  QV getInPackageWidth();

  void setInPackageWidth(QV value);

  String getIncludedAccessories();

  void setIncludedAccessories(String value);

  RF getInstructionsForUse();

  void setInstructionsForUse(RF value);

  boolean getIsProductRecalled();

  void setIsProductRecalled(boolean value);

  String getJws();

  void setJws(String value);

  O getManufacturer();

  void setManufacturer(O value);

  WP getManufacturersWarranty();

  void setManufacturersWarranty(WP value);

  O getManufacturingPlant();

  void setManufacturingPlant(O value);

  QV getMassPerUnitArea();

  void setMassPerUnitArea(QV value);

  QV getNetArea();

  void setNetArea(QV value);

  QV getNetContent();

  void setNetContent(QV value);

  QV getNetWeight();

  void setNetWeight(QV value);

  List<OC> getOrganicClaim();

  void setOrganicClaim(List<OC> value);

  QV getOutOfPackageDepth();

  void setOutOfPackageDepth(QV value);

  QV getOutOfPackageDiameter();

  void setOutOfPackageDiameter(QV value);

  QV getOutOfPackageHeight();

  void setOutOfPackageHeight(QV value);

  QV getOutOfPackageWidth();

  void setOutOfPackageWidth(QV value);

  PD getPackaging();

  void setPackaging(PD value);

  LocalDate getPackagingDate();

  void setPackagingDate(LocalDate value);

  PackagingMarkedLabelAccreditationCode getPackagingMarkedLabelAccreditation();

  void setPackagingMarkedLabelAccreditation(PackagingMarkedLabelAccreditationCode value);

  P getPrimaryAlternateProduct();

  void setPrimaryAlternateProduct(P value);

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

  LocalDate getProductionDate();

  void setProductionDate(LocalDate value);

  LocalDate getProductionDateTime();

  void setProductionDateTime(LocalDate value);

  String getProductionVariantDescription();

  void setProductionVariantDescription(String value);

  LocalDateTime getProductionVariantEffectiveDateTime();

  void setProductionVariantEffectiveDateTime(LocalDateTime value);

  String getProvenanceStatement();

  void setProvenanceStatement(String value);

  List<RF> getReferencedFile();

  void setReferencedFile(List<RF> value);

  String getRegulatedProductName();

  void setRegulatedProductName(String value);

  P getReplacedByProduct();

  void setReplacedByProduct(P value);

  P getReplacedProduct();

  void setReplacedProduct(P value);

  LocalDate getSellByDate();

  void setSellByDate(LocalDate value);

  SC getSizeCode();

  void setSizeCode(SC value);

  BigInteger getSupplierSpecifiedMinimumConsumerStorageDays();

  void setSupplierSpecifiedMinimumConsumerStorageDays(BigInteger value);

  List<TM> getTargetMarket();

  void setTargetMarket(List<TM> value);

  String getVariantDescription();

  void setVariantDescription(String value);

  String getWarningCopyDescription();

  void setWarningCopyDescription(String value);
}
