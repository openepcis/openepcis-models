package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.*;

public interface FoodBeverageTobaccoProduct {
    String getAllergenSpecificationAgency();

    void setAllergenSpecificationAgency(String value);

    String getAllergenSpecificationName();

    void setAllergenSpecificationName(String value);

    String getAllergenStatement();

    void setAllergenStatement(String value);

    NutritionMeasurementType getBiotinPerNutrientBasis();

    void setBiotinPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getCalciumPerNutrientBasis();

    void setCalciumPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getCarbohydratesPerNutrientBasis();

    void setCarbohydratesPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getChloridePerNutrientBasis();

    void setChloridePerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getCholesterolPerNutrientBasis();

    void setCholesterolPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getChromiumPerNutrientBasis();

    void setChromiumPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getCopperPerNutrientBasis();

    void setCopperPerNutrientBasis(NutritionMeasurementType value);

    DietTypeCodeDetails getDietCode();

    void setDietCode(DietTypeCodeDetails value);

    String getDietTypeDescription();

    void setDietTypeDescription(String value);

    QuantitativeValue getDrainedWeight();

    void setDrainedWeight(QuantitativeValue value);

    NutritionMeasurementType getEnergyFromFatPerNutrientBasis();

    void setEnergyFromFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getEnergyPerNutrientBasis();

    void setEnergyPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getFatPerNutrientBasis();

    void setFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getFibrePerNutrientBasis();

    void setFibrePerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getFluoridePerNutrientBasis();

    void setFluoridePerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getFolicAcidPerNutrientBasis();

    void setFolicAcidPerNutrientBasis(NutritionMeasurementType value);

    FoodBeverageRefrigerationClaimCode getFoodBeverageRefrigerationClaim();

    void setFoodBeverageRefrigerationClaim(FoodBeverageRefrigerationClaimCode value);

    FoodBeverageTargetUseCode getFoodBeverageTargetUse();

    void setFoodBeverageTargetUse(FoodBeverageTargetUseCode value);

    LevelOfContainmentCode getGeneticallyModifiedDeclaration();

    void setGeneticallyModifiedDeclaration(LevelOfContainmentCode value);

    AllergenDetails getHasAllergen();

    void setHasAllergen(AllergenDetails value);

    FoodBeverageTobaccoIngredientDetails getIngredient();

    void setIngredient(FoodBeverageTobaccoIngredientDetails value);

    String getIngredientOfConcern();

    void setIngredientOfConcern(String value);

    String getIngredientStatement();

    void setIngredientStatement(String value);

    NutritionMeasurementType getIodinePerNutrientBasis();

    void setIodinePerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getIronPerNutrientBasis();

    void setIronPerNutrientBasis(NutritionMeasurementType value);

    NonbinaryLogicCode getIrradiatedCode();

    void setIrradiatedCode(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsInstant();

    void setIsInstant(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsSliced();

    void setIsSliced(NonbinaryLogicCode value);

    String getJuiceContentPercent();

    void setJuiceContentPercent(String value);

    NutritionMeasurementType getMagnesiumPerNutrientBasis();

    void setMagnesiumPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getManganesePerNutrientBasis();

    void setManganesePerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getMolybdenumPerNutrientBasis();

    void setMolybdenumPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getMonounsaturatedFatPerNutrientBasis();

    void setMonounsaturatedFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getNiacinPerNutrientBasis();

    void setNiacinPerNutrientBasis(NutritionMeasurementType value);

    String getNumberOfServingsPerPackage();

    void setNumberOfServingsPerPackage(String value);

    MeasurementPrecisionCode getNumberOfServingsPerPackageMeasurementPrecision();

    void setNumberOfServingsPerPackageMeasurementPrecision(MeasurementPrecisionCode value);

    String getNumberOfServingsRangeDescription();

    void setNumberOfServingsRangeDescription(String value);

    QuantitativeValue getNutrientBasisQuantity();

    void setNutrientBasisQuantity(QuantitativeValue value);

    NutrientBasisQuantityCode getNutrientBasisQuantityType();

    void setNutrientBasisQuantityType(NutrientBasisQuantityCode value);

    MeasurementPrecisionCode getNutrientMeasurementPrecision();

    void setNutrientMeasurementPrecision(MeasurementPrecisionCode value);

    NutritionalClaimTypeCode getNutritionalClaim();

    void setNutritionalClaim(NutritionalClaimTypeCode value);

    String getNutritionalClaimStatement();

    void setNutritionalClaimStatement(String value);

    PackagingMarkedDietAllergenCode getPackagingMarkedDietAllergenType();

    void setPackagingMarkedDietAllergenType(PackagingMarkedDietAllergenCode value);

    PackagingMarkedFreeFromCode getPackagingMarkedFreeFrom();

    void setPackagingMarkedFreeFrom(PackagingMarkedFreeFromCode value);

    NutritionMeasurementType getPantothenicAcidPerNutrientBasis();

    void setPantothenicAcidPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getPhosphorusPerNutrientBasis();

    void setPhosphorusPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getPolyolsPerNutrientBasis();

    void setPolyolsPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getPolyunsaturatedFatPerNutrientBasis();

    void setPolyunsaturatedFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getPotassiumPerNutrientBasis();

    void setPotassiumPerNutrientBasis(NutritionMeasurementType value);

    FoodAndBeveragePreparationInformation getPreparationInformation();

    void setPreparationInformation(FoodAndBeveragePreparationInformation value);

    PreservationTechniqueCode getPreservationTechnique();

    void setPreservationTechnique(PreservationTechniqueCode value);

    NutritionMeasurementType getProteinPerNutrientBasis();

    void setProteinPerNutrientBasis(NutritionMeasurementType value);

    NonbinaryLogicCode getReheatingClaim();

    void setReheatingClaim(NonbinaryLogicCode value);

    NutritionMeasurementType getRiboflavinPerNutrientBasis();

    void setRiboflavinPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getSaltPerNutrientBasis();

    void setSaltPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getSaturatedFatPerNutrientBasis();

    void setSaturatedFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getSeleniumPerNutrientBasis();

    void setSeleniumPerNutrientBasis(NutritionMeasurementType value);

    QuantitativeValue getServingSize();

    void setServingSize(QuantitativeValue value);

    String getServingSizeDescription();

    void setServingSizeDescription(String value);

    String getServingSuggestion();

    void setServingSuggestion(String value);

    NutritionMeasurementType getSodiumPerNutrientBasis();

    void setSodiumPerNutrientBasis(NutritionMeasurementType value);

    SourceAnimalCode getSourceAnimal();

    void setSourceAnimal(SourceAnimalCode value);

    NutritionMeasurementType getStarchPerNutrientBasis();

    void setStarchPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getSugarsPerNutrientBasis();

    void setSugarsPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getThiaminPerNutrientBasis();

    void setThiaminPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getTransFatPerNutrientBasis();

    void setTransFatPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminAPerNutrientBasis();

    void setVitaminAPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminB12PerNutrientBasis();

    void setVitaminB12PerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminB6PerNutrientBasis();

    void setVitaminB6PerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminCPerNutrientBasis();

    void setVitaminCPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminDPerNutrientBasis();

    void setVitaminDPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminEPerNutrientBasis();

    void setVitaminEPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getVitaminKPerNutrientBasis();

    void setVitaminKPerNutrientBasis(NutritionMeasurementType value);

    NutritionMeasurementType getZincPerNutrientBasis();

    void setZincPerNutrientBasis(NutritionMeasurementType value);
}
