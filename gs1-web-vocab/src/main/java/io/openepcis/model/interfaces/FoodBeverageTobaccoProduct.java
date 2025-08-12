package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

import java.util.LinkedHashMap;
import java.util.List;

public interface FoodBeverageTobaccoProduct<
        NM extends NutritionMeasurementType,
        FBI extends FoodAndBeveragePreparationInformation,
        AD extends AllergenDetails,
        FBT extends FoodBeverageTobaccoIngredientDetails,
        QV extends QuantitativeValue,
        DT extends DietTypeCodeDetails> {
    LinkedHashMap<String, String> getAllergenSpecificationAgency();

    void setAllergenSpecificationAgency(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAllergenSpecificationName();

    void setAllergenSpecificationName(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getAllergenStatement();

    void setAllergenStatement(LinkedHashMap<String, String> value);

    NM getBiotinPerNutrientBasis();

    void setBiotinPerNutrientBasis(NM value);

    NM getCalciumPerNutrientBasis();

    void setCalciumPerNutrientBasis(NM value);

    NM getCarbohydratesPerNutrientBasis();

    void setCarbohydratesPerNutrientBasis(NM value);

    NM getChloridePerNutrientBasis();

    void setChloridePerNutrientBasis(NM value);

    NM getCholesterolPerNutrientBasis();

    void setCholesterolPerNutrientBasis(NM value);

    NM getChromiumPerNutrientBasis();

    void setChromiumPerNutrientBasis(NM value);

    NM getCopperPerNutrientBasis();

    void setCopperPerNutrientBasis(NM value);

    List<DT> getDietCode();

    void setDietCode(List<DT> value);

    LinkedHashMap<String, String> getDietTypeDescription();

    void setDietTypeDescription(LinkedHashMap<String, String> value);

    QV getDrainedWeight();

    void setDrainedWeight(QV value);

    NM getEnergyFromFatPerNutrientBasis();

    void setEnergyFromFatPerNutrientBasis(NM value);

    NM getEnergyPerNutrientBasis();

    void setEnergyPerNutrientBasis(NM value);

    NM getFatPerNutrientBasis();

    void setFatPerNutrientBasis(NM value);

    NM getFibrePerNutrientBasis();

    void setFibrePerNutrientBasis(NM value);

    NM getFluoridePerNutrientBasis();

    void setFluoridePerNutrientBasis(NM value);

    NM getFolicAcidPerNutrientBasis();

    void setFolicAcidPerNutrientBasis(NM value);

    FoodBeverageRefrigerationClaimCode getFoodBeverageRefrigerationClaim();

    void setFoodBeverageRefrigerationClaim(FoodBeverageRefrigerationClaimCode value);

    FoodBeverageTargetUseCode getFoodBeverageTargetUse();

    void setFoodBeverageTargetUse(FoodBeverageTargetUseCode value);

    LevelOfContainmentCode getGeneticallyModifiedDeclaration();

    void setGeneticallyModifiedDeclaration(LevelOfContainmentCode value);

    List<AD> getHasAllergen();

    void setHasAllergen(List<AD> value);

    List<FBT> getIngredient();

    void setIngredient(List<FBT> value);

    LinkedHashMap<String, String> getIngredientOfConcern();

    void setIngredientOfConcern(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getIngredientStatement();

    void setIngredientStatement(LinkedHashMap<String, String> value);

    NM getIodinePerNutrientBasis();

    void setIodinePerNutrientBasis(NM value);

    NM getIronPerNutrientBasis();

    void setIronPerNutrientBasis(NM value);

    NonbinaryLogicCode getIrradiatedCode();

    void setIrradiatedCode(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsInstant();

    void setIsInstant(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsSliced();

    void setIsSliced(NonbinaryLogicCode value);

    float getJuiceContentPercent();

    void setJuiceContentPercent(float value);

    NM getMagnesiumPerNutrientBasis();

    void setMagnesiumPerNutrientBasis(NM value);

    NM getManganesePerNutrientBasis();

    void setManganesePerNutrientBasis(NM value);

    NM getMolybdenumPerNutrientBasis();

    void setMolybdenumPerNutrientBasis(NM value);

    NM getMonounsaturatedFatPerNutrientBasis();

    void setMonounsaturatedFatPerNutrientBasis(NM value);

    NM getNiacinPerNutrientBasis();

    void setNiacinPerNutrientBasis(NM value);

    float getNumberOfServingsPerPackage();

    void setNumberOfServingsPerPackage(float value);

    MeasurementPrecisionCode getNumberOfServingsPerPackageMeasurementPrecision();

    void setNumberOfServingsPerPackageMeasurementPrecision(MeasurementPrecisionCode value);

    LinkedHashMap<String, String> getNumberOfServingsRangeDescription();

    void setNumberOfServingsRangeDescription(LinkedHashMap<String, String> value);

    QV getNutrientBasisQuantity();

    void setNutrientBasisQuantity(QV value);

    NutrientBasisQuantityCode getNutrientBasisQuantityType();

    void setNutrientBasisQuantityType(NutrientBasisQuantityCode value);

    MeasurementPrecisionCode getNutrientMeasurementPrecision();

    void setNutrientMeasurementPrecision(MeasurementPrecisionCode value);

    NutritionalClaimTypeCode getNutritionalClaim();

    void setNutritionalClaim(NutritionalClaimTypeCode value);

    LinkedHashMap<String, String> getNutritionalClaimStatement();

    void setNutritionalClaimStatement(LinkedHashMap<String, String> value);

    PackagingMarkedDietAllergenCode getPackagingMarkedDietAllergenType();

    void setPackagingMarkedDietAllergenType(PackagingMarkedDietAllergenCode value);

    PackagingMarkedFreeFromCode getPackagingMarkedFreeFrom();

    void setPackagingMarkedFreeFrom(PackagingMarkedFreeFromCode value);

    NM getPantothenicAcidPerNutrientBasis();

    void setPantothenicAcidPerNutrientBasis(NM value);

    NM getPhosphorusPerNutrientBasis();

    void setPhosphorusPerNutrientBasis(NM value);

    NM getPolyolsPerNutrientBasis();

    void setPolyolsPerNutrientBasis(NM value);

    NM getPolyunsaturatedFatPerNutrientBasis();

    void setPolyunsaturatedFatPerNutrientBasis(NM value);

    NM getPotassiumPerNutrientBasis();

    void setPotassiumPerNutrientBasis(NM value);

    FBI getPreparationInformation();

    void setPreparationInformation(FBI value);

    PreservationTechniqueCode getPreservationTechnique();

    void setPreservationTechnique(PreservationTechniqueCode value);

    NM getProteinPerNutrientBasis();

    void setProteinPerNutrientBasis(NM value);

    NonbinaryLogicCode getReheatingClaim();

    void setReheatingClaim(NonbinaryLogicCode value);

    NM getRiboflavinPerNutrientBasis();

    void setRiboflavinPerNutrientBasis(NM value);

    NM getSaltPerNutrientBasis();

    void setSaltPerNutrientBasis(NM value);

    NM getSaturatedFatPerNutrientBasis();

    void setSaturatedFatPerNutrientBasis(NM value);

    NM getSeleniumPerNutrientBasis();

    void setSeleniumPerNutrientBasis(NM value);

    QV getServingSize();

    void setServingSize(QV value);

    LinkedHashMap<String, String> getServingSizeDescription();

    void setServingSizeDescription(LinkedHashMap<String, String> value);

    LinkedHashMap<String, String> getServingSuggestion();

    void setServingSuggestion(LinkedHashMap<String, String> value);

    NM getSodiumPerNutrientBasis();

    void setSodiumPerNutrientBasis(NM value);

    SourceAnimalCode getSourceAnimal();

    void setSourceAnimal(SourceAnimalCode value);

    NM getStarchPerNutrientBasis();

    void setStarchPerNutrientBasis(NM value);

    NM getSugarsPerNutrientBasis();

    void setSugarsPerNutrientBasis(NM value);

    NM getThiaminPerNutrientBasis();

    void setThiaminPerNutrientBasis(NM value);

    NM getTransFatPerNutrientBasis();

    void setTransFatPerNutrientBasis(NM value);

    NM getVitaminAPerNutrientBasis();

    void setVitaminAPerNutrientBasis(NM value);

    NM getVitaminB12PerNutrientBasis();

    void setVitaminB12PerNutrientBasis(NM value);

    NM getVitaminB6PerNutrientBasis();

    void setVitaminB6PerNutrientBasis(NM value);

    NM getVitaminCPerNutrientBasis();

    void setVitaminCPerNutrientBasis(NM value);

    NM getVitaminDPerNutrientBasis();

    void setVitaminDPerNutrientBasis(NM value);

    NM getVitaminEPerNutrientBasis();

    void setVitaminEPerNutrientBasis(NM value);

    NM getVitaminKPerNutrientBasis();

    void setVitaminKPerNutrientBasis(NM value);

    NM getZincPerNutrientBasis();

    void setZincPerNutrientBasis(NM value);
}
