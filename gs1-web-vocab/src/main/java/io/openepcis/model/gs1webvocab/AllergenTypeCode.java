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
 * Java class for AllergenTypeCode.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <simpleType name="AllergenTypeCode">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="1,3-BIS-(2,4-DIAMINOPHENOXY)PROPANE"/>
 *     <enumeration value="1-NAPHTHOL"/>
 *     <enumeration value="2,6-DIMETHOXY-3,5-PYRIDINEDIAMINE_HCL"/>
 *     <enumeration value="2-HYDROXYETHYL-PICRAMIC_ACID"/>
 *     <enumeration value="2-METHYL-5-HYDROXYETHYLAMINOPHENOL"/>
 *     <enumeration value="3-AMINO-2,4-DICHLOROPHENOL"/>
 *     <enumeration value="3-AMINOPHENOL"/>
 *     <enumeration value="4-AMINO-3-NITROPHENOL"/>
 *     <enumeration value="4-HYDROXY-PROPYLAMINO-3-NITROPHENOL"/>
 *     <enumeration value="ABALONE"/>
 *     <enumeration value="ALMONDS"/>
 *     <enumeration value="ALPHA_ISOMETHYL_IONONE"/>
 *     <enumeration value="AMYLCINNAMYL_ALCOHOL"/>
 *     <enumeration value="AMYL_CINNAMAL"/>
 *     <enumeration value="ANCHOVY"/>
 *     <enumeration value="ANISE_ALCOHOL"/>
 *     <enumeration value="BARLEY"/>
 *     <enumeration value="BARNACLE"/>
 *     <enumeration value="BASA"/>
 *     <enumeration value="BASS"/>
 *     <enumeration value="BEECH_NUTS"/>
 *     <enumeration value="BEEF"/>
 *     <enumeration value="BENZYL_ALCOHOL"/>
 *     <enumeration value="BENZYL_BENZOATE"/>
 *     <enumeration value="BENZYL_CINNAMATE"/>
 *     <enumeration value="BENZYL_SALICYLATE"/>
 *     <enumeration value="BLUEFISH"/>
 *     <enumeration value="BRAZIL_NUTS"/>
 *     <enumeration value="BREAM"/>
 *     <enumeration value="BUTTERNUTS"/>
 *     <enumeration value="BUTYLPHENYL_METHYLPROPIONATE"/>
 *     <enumeration value="CARP"/>
 *     <enumeration value="CARROTS"/>
 *     <enumeration value="CASHEW_NUTS"/>
 *     <enumeration value="CATFISH"/>
 *     <enumeration value="CELERY"/>
 *     <enumeration value="CEREALS_CONTAINING_GLUTEN"/>
 *     <enumeration value="CHAR"/>
 *     <enumeration value="CHESTNUTS"/>
 *     <enumeration value="CHICKEN_MEAT"/>
 *     <enumeration value="CHINQUAPINS"/>
 *     <enumeration value="CHUB"/>
 *     <enumeration value="CINNAMAL"/>
 *     <enumeration value="CINNAMYL_ALCOHOL"/>
 *     <enumeration value="CISCO"/>
 *     <enumeration value="CITRAL"/>
 *     <enumeration value="CITRONELLOL"/>
 *     <enumeration value="CLAM"/>
 *     <enumeration value="COCKLE"/>
 *     <enumeration value="COCOA"/>
 *     <enumeration value="COCONUTS"/>
 *     <enumeration value="COD"/>
 *     <enumeration value="CONCH"/>
 *     <enumeration value="CORIANDER"/>
 *     <enumeration value="CORN"/>
 *     <enumeration value="COTTON_SEEDS"/>
 *     <enumeration value="COUMARIN"/>
 *     <enumeration value="CRAB"/>
 *     <enumeration value="CRAWFISH"/>
 *     <enumeration value="CRUSTACEANS"/>
 *     <enumeration value="D-LIMONENE"/>
 *     <enumeration value="DIAMINOPHENOLS"/>
 *     <enumeration value="EEL"/>
 *     <enumeration value="EGGS"/>
 *     <enumeration value="EUGENOL"/>
 *     <enumeration value="EVERNIA_FURFURACEA"/>
 *     <enumeration value="EVERNIA_PRUNASTRI"/>
 *     <enumeration value="FARNESOL"/>
 *     <enumeration value="FISH"/>
 *     <enumeration value="FLOUNDER"/>
 *     <enumeration value="GERANIOL"/>
 *     <enumeration value="GINKGO_NUTS"/>
 *     <enumeration value="GLUTAMATE"/>
 *     <enumeration value="GLUTEN"/>
 *     <enumeration value="GROUPER"/>
 *     <enumeration value="HADDOCK"/>
 *     <enumeration value="HAKE"/>
 *     <enumeration value="HALIBUT"/>
 *     <enumeration value="HAZELNUTS"/>
 *     <enumeration value="HC_BLUE_NO_11"/>
 *     <enumeration value="HC_BLUE_NO_12"/>
 *     <enumeration value="HERRING"/>
 *     <enumeration value="HEXYL_CINNAMAL"/>
 *     <enumeration value="HICKORY_NUTS"/>
 *     <enumeration value="HYDROXYBENZOMORPHOLINE"/>
 *     <enumeration value="HYDROXYCITRONELLAL"/>
 *     <enumeration value="HYDROXYETHYL-2-NITRO-P-TOLUIDINE"/>
 *     <enumeration value="HYDROXYISOHEXYL_3-CYCLOHEXENE_CARBOXALDEHYDE_ISOEUGENOL_LIMONENE_LINAL"/>
 *     <enumeration value="HYDROXYPROPYL_BIS(N-HYDROXYETHYL-P-PHENYLDIAMINE)_HCL"/>
 *     <enumeration value="ISOEUGENOL"/>
 *     <enumeration value="KAMUT"/>
 *     <enumeration value="KRILL"/>
 *     <enumeration value="LACTOSE"/>
 *     <enumeration value="LAND"/>
 *     <enumeration value="LICHEE_NUTS"/>
 *     <enumeration value="LIMPETS"/>
 *     <enumeration value="LINALOOL"/>
 *     <enumeration value="LOBSTER"/>
 *     <enumeration value="LUPINE"/>
 *     <enumeration value="MACADAMIA_NUTS"/>
 *     <enumeration value="MACKEREL"/>
 *     <enumeration value="MAHI_MAHI"/>
 *     <enumeration value="MARLIN"/>
 *     <enumeration value="MELATONIN"/>
 *     <enumeration value="METHYL_2_OCTYNOATE"/>
 *     <enumeration value="METHYL_HEPTIN_CARBONATE"/>
 *     <enumeration value="MILK"/>
 *     <enumeration value="MOLLUSCS"/>
 *     <enumeration value="MONKFISH_(ANGLERFISH,_LOTTE)"/>
 *     <enumeration value="MUSSELS"/>
 *     <enumeration value="MUSTARD"/>
 *     <enumeration value="NO_DECLARED_ALLERGENS"/>
 *     <enumeration value="OAT"/>
 *     <enumeration value="OCTOPUS"/>
 *     <enumeration value="ORANGE_ROUGHY"/>
 *     <enumeration value="OYSTERS"/>
 *     <enumeration value="P-METHYLAMINOPHENOL"/>
 *     <enumeration value="P-PHENYLENEDIAMINE"/>
 *     <enumeration value="PEANUTS"/>
 *     <enumeration value="PEAS"/>
 *     <enumeration value="PECAN_NUTS"/>
 *     <enumeration value="PERCH"/>
 *     <enumeration value="PERIWINKLE"/>
 *     <enumeration value="PIKE"/>
 *     <enumeration value="PILI_NUTS"/>
 *     <enumeration value="PINE_NUTS"/>
 *     <enumeration value="PISTACHIOS"/>
 *     <enumeration value="PLAICE"/>
 *     <enumeration value="POD_FRUITS"/>
 *     <enumeration value="POLLOCK"/>
 *     <enumeration value="POMPANO"/>
 *     <enumeration value="POPPY_SEEDS"/>
 *     <enumeration value="PORGY"/>
 *     <enumeration value="PORK"/>
 *     <enumeration value="PRAWNS"/>
 *     <enumeration value="PULSES"/>
 *     <enumeration value="QUAHAUGS"/>
 *     <enumeration value="QUEENSLAND_NUTS"/>
 *     <enumeration value="ROCKFISH"/>
 *     <enumeration value="RYE"/>
 *     <enumeration value="SALICYLATE"/>
 *     <enumeration value="SALMON"/>
 *     <enumeration value="SARDINE"/>
 *     <enumeration value="SCALLOPS"/>
 *     <enumeration value="SEED_PRODUCTS"/>
 *     <enumeration value="SESAME_SEEDS"/>
 *     <enumeration value="SHARK"/>
 *     <enumeration value="SHEA_NUTS"/>
 *     <enumeration value="SHELLFISH"/>
 *     <enumeration value="SHRIMP"/>
 *     <enumeration value="SMELT"/>
 *     <enumeration value="SNAPPER"/>
 *     <enumeration value="SOLE"/>
 *     <enumeration value="SOYBEANS"/>
 *     <enumeration value="SPELT"/>
 *     <enumeration value="SQUID_(CALAMARI)"/>
 *     <enumeration value="STURGEON"/>
 *     <enumeration value="SULPHUR_DIOXIDE"/>
 *     <enumeration value="SUNFLOWER_SEEDS"/>
 *     <enumeration value="SWORDFISH"/>
 *     <enumeration value="TILAPIA"/>
 *     <enumeration value="TOLUENE-2,5-DIAMINE"/>
 *     <enumeration value="TREE_NUTS"/>
 *     <enumeration value="TREE_NUT_TRACES"/>
 *     <enumeration value="TRITICALE"/>
 *     <enumeration value="TROUT"/>
 *     <enumeration value="TUNA"/>
 *     <enumeration value="TURBOT"/>
 *     <enumeration value="WALLEYE"/>
 *     <enumeration value="WALNUTS"/>
 *     <enumeration value="WHEAT"/>
 *     <enumeration value="WHELKS"/>
 *     <enumeration value="WHITEFISH"/>
 *     <enumeration value="WHITING"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 */
@XmlType(name = "AllergenTypeCode")
@XmlEnum
public enum AllergenTypeCode {
  @XmlEnumValue("1,3-BIS-(2,4-DIAMINOPHENOXY)PROPANE")
  VALUE_1("1,3-BIS-(2,4-DIAMINOPHENOXY)PROPANE"),
  @XmlEnumValue("1-NAPHTHOL")
  VALUE_2("1-NAPHTHOL"),
  @XmlEnumValue("2,6-DIMETHOXY-3,5-PYRIDINEDIAMINE_HCL")
  VALUE_3("2,6-DIMETHOXY-3,5-PYRIDINEDIAMINE_HCL"),
  @XmlEnumValue("2-HYDROXYETHYL-PICRAMIC_ACID")
  VALUE_4("2-HYDROXYETHYL-PICRAMIC_ACID"),
  @XmlEnumValue("2-METHYL-5-HYDROXYETHYLAMINOPHENOL")
  VALUE_5("2-METHYL-5-HYDROXYETHYLAMINOPHENOL"),
  @XmlEnumValue("3-AMINO-2,4-DICHLOROPHENOL")
  VALUE_6("3-AMINO-2,4-DICHLOROPHENOL"),
  @XmlEnumValue("3-AMINOPHENOL")
  VALUE_7("3-AMINOPHENOL"),
  @XmlEnumValue("4-AMINO-3-NITROPHENOL")
  VALUE_8("4-AMINO-3-NITROPHENOL"),
  @XmlEnumValue("4-HYDROXY-PROPYLAMINO-3-NITROPHENOL")
  VALUE_9("4-HYDROXY-PROPYLAMINO-3-NITROPHENOL"),
  @XmlEnumValue("ABALONE")
  VALUE_10("ABALONE"),
  @XmlEnumValue("ALMONDS")
  VALUE_11("ALMONDS"),
  @XmlEnumValue("ALPHA_ISOMETHYL_IONONE")
  VALUE_12("ALPHA_ISOMETHYL_IONONE"),
  @XmlEnumValue("AMYLCINNAMYL_ALCOHOL")
  VALUE_13("AMYLCINNAMYL_ALCOHOL"),
  @XmlEnumValue("AMYL_CINNAMAL")
  VALUE_14("AMYL_CINNAMAL"),
  @XmlEnumValue("ANCHOVY")
  VALUE_15("ANCHOVY"),
  @XmlEnumValue("ANISE_ALCOHOL")
  VALUE_16("ANISE_ALCOHOL"),
  @XmlEnumValue("BARLEY")
  VALUE_17("BARLEY"),
  @XmlEnumValue("BARNACLE")
  VALUE_18("BARNACLE"),
  @XmlEnumValue("BASA")
  VALUE_19("BASA"),
  @XmlEnumValue("BASS")
  VALUE_20("BASS"),
  @XmlEnumValue("BEECH_NUTS")
  VALUE_21("BEECH_NUTS"),
  @XmlEnumValue("BEEF")
  VALUE_22("BEEF"),
  @XmlEnumValue("BENZYL_ALCOHOL")
  VALUE_23("BENZYL_ALCOHOL"),
  @XmlEnumValue("BENZYL_BENZOATE")
  VALUE_24("BENZYL_BENZOATE"),
  @XmlEnumValue("BENZYL_CINNAMATE")
  VALUE_25("BENZYL_CINNAMATE"),
  @XmlEnumValue("BENZYL_SALICYLATE")
  VALUE_26("BENZYL_SALICYLATE"),
  @XmlEnumValue("BLUEFISH")
  VALUE_27("BLUEFISH"),
  @XmlEnumValue("BRAZIL_NUTS")
  VALUE_28("BRAZIL_NUTS"),
  @XmlEnumValue("BREAM")
  VALUE_29("BREAM"),
  @XmlEnumValue("BUTTERNUTS")
  VALUE_30("BUTTERNUTS"),
  @XmlEnumValue("BUTYLPHENYL_METHYLPROPIONATE")
  VALUE_31("BUTYLPHENYL_METHYLPROPIONATE"),
  @XmlEnumValue("CARP")
  VALUE_32("CARP"),
  @XmlEnumValue("CARROTS")
  VALUE_33("CARROTS"),
  @XmlEnumValue("CASHEW_NUTS")
  VALUE_34("CASHEW_NUTS"),
  @XmlEnumValue("CATFISH")
  VALUE_35("CATFISH"),
  @XmlEnumValue("CELERY")
  VALUE_36("CELERY"),
  @XmlEnumValue("CEREALS_CONTAINING_GLUTEN")
  VALUE_37("CEREALS_CONTAINING_GLUTEN"),
  @XmlEnumValue("CHAR")
  VALUE_38("CHAR"),
  @XmlEnumValue("CHESTNUTS")
  VALUE_39("CHESTNUTS"),
  @XmlEnumValue("CHICKEN_MEAT")
  VALUE_40("CHICKEN_MEAT"),
  @XmlEnumValue("CHINQUAPINS")
  VALUE_41("CHINQUAPINS"),
  @XmlEnumValue("CHUB")
  VALUE_42("CHUB"),
  @XmlEnumValue("CINNAMAL")
  VALUE_43("CINNAMAL"),
  @XmlEnumValue("CINNAMYL_ALCOHOL")
  VALUE_44("CINNAMYL_ALCOHOL"),
  @XmlEnumValue("CISCO")
  VALUE_45("CISCO"),
  @XmlEnumValue("CITRAL")
  VALUE_46("CITRAL"),
  @XmlEnumValue("CITRONELLOL")
  VALUE_47("CITRONELLOL"),
  @XmlEnumValue("CLAM")
  VALUE_48("CLAM"),
  @XmlEnumValue("COCKLE")
  VALUE_49("COCKLE"),
  @XmlEnumValue("COCOA")
  VALUE_50("COCOA"),
  @XmlEnumValue("COCONUTS")
  VALUE_51("COCONUTS"),
  @XmlEnumValue("COD")
  VALUE_52("COD"),
  @XmlEnumValue("CONCH")
  VALUE_53("CONCH"),
  @XmlEnumValue("CORIANDER")
  VALUE_54("CORIANDER"),
  @XmlEnumValue("CORN")
  VALUE_55("CORN"),
  @XmlEnumValue("COTTON_SEEDS")
  VALUE_56("COTTON_SEEDS"),
  @XmlEnumValue("COUMARIN")
  VALUE_57("COUMARIN"),
  @XmlEnumValue("CRAB")
  VALUE_58("CRAB"),
  @XmlEnumValue("CRAWFISH")
  VALUE_59("CRAWFISH"),
  @XmlEnumValue("CRUSTACEANS")
  VALUE_60("CRUSTACEANS"),
  @XmlEnumValue("D-LIMONENE")
  VALUE_61("D-LIMONENE"),
  @XmlEnumValue("DIAMINOPHENOLS")
  VALUE_62("DIAMINOPHENOLS"),
  @XmlEnumValue("EEL")
  VALUE_63("EEL"),
  @XmlEnumValue("EGGS")
  VALUE_64("EGGS"),
  @XmlEnumValue("EUGENOL")
  VALUE_65("EUGENOL"),
  @XmlEnumValue("EVERNIA_FURFURACEA")
  VALUE_66("EVERNIA_FURFURACEA"),
  @XmlEnumValue("EVERNIA_PRUNASTRI")
  VALUE_67("EVERNIA_PRUNASTRI"),
  @XmlEnumValue("FARNESOL")
  VALUE_68("FARNESOL"),
  @XmlEnumValue("FISH")
  VALUE_69("FISH"),
  @XmlEnumValue("FLOUNDER")
  VALUE_70("FLOUNDER"),
  @XmlEnumValue("GERANIOL")
  VALUE_71("GERANIOL"),
  @XmlEnumValue("GINKGO_NUTS")
  VALUE_72("GINKGO_NUTS"),
  @XmlEnumValue("GLUTAMATE")
  VALUE_73("GLUTAMATE"),
  @XmlEnumValue("GLUTEN")
  VALUE_74("GLUTEN"),
  @XmlEnumValue("GROUPER")
  VALUE_75("GROUPER"),
  @XmlEnumValue("HADDOCK")
  VALUE_76("HADDOCK"),
  @XmlEnumValue("HAKE")
  VALUE_77("HAKE"),
  @XmlEnumValue("HALIBUT")
  VALUE_78("HALIBUT"),
  @XmlEnumValue("HAZELNUTS")
  VALUE_79("HAZELNUTS"),
  @XmlEnumValue("HC_BLUE_NO_11")
  VALUE_80("HC_BLUE_NO_11"),
  @XmlEnumValue("HC_BLUE_NO_12")
  VALUE_81("HC_BLUE_NO_12"),
  @XmlEnumValue("HERRING")
  VALUE_82("HERRING"),
  @XmlEnumValue("HEXYL_CINNAMAL")
  VALUE_83("HEXYL_CINNAMAL"),
  @XmlEnumValue("HICKORY_NUTS")
  VALUE_84("HICKORY_NUTS"),
  @XmlEnumValue("HYDROXYBENZOMORPHOLINE")
  VALUE_85("HYDROXYBENZOMORPHOLINE"),
  @XmlEnumValue("HYDROXYCITRONELLAL")
  VALUE_86("HYDROXYCITRONELLAL"),
  @XmlEnumValue("HYDROXYETHYL-2-NITRO-P-TOLUIDINE")
  VALUE_87("HYDROXYETHYL-2-NITRO-P-TOLUIDINE"),
  @XmlEnumValue("HYDROXYISOHEXYL_3-CYCLOHEXENE_CARBOXALDEHYDE_ISOEUGENOL_LIMONENE_LINAL")
  VALUE_88("HYDROXYISOHEXYL_3-CYCLOHEXENE_CARBOXALDEHYDE_ISOEUGENOL_LIMONENE_LINAL"),
  @XmlEnumValue("HYDROXYPROPYL_BIS(N-HYDROXYETHYL-P-PHENYLDIAMINE)_HCL")
  VALUE_89("HYDROXYPROPYL_BIS(N-HYDROXYETHYL-P-PHENYLDIAMINE)_HCL"),
  @XmlEnumValue("ISOEUGENOL")
  VALUE_90("ISOEUGENOL"),
  @XmlEnumValue("KAMUT")
  VALUE_91("KAMUT"),
  @XmlEnumValue("KRILL")
  VALUE_92("KRILL"),
  @XmlEnumValue("LACTOSE")
  VALUE_93("LACTOSE"),
  @XmlEnumValue("LAND")
  VALUE_94("LAND"),
  @XmlEnumValue("LICHEE_NUTS")
  VALUE_95("LICHEE_NUTS"),
  @XmlEnumValue("LIMPETS")
  VALUE_96("LIMPETS"),
  @XmlEnumValue("LINALOOL")
  VALUE_97("LINALOOL"),
  @XmlEnumValue("LOBSTER")
  VALUE_98("LOBSTER"),
  @XmlEnumValue("LUPINE")
  VALUE_99("LUPINE"),
  @XmlEnumValue("MACADAMIA_NUTS")
  VALUE_100("MACADAMIA_NUTS"),
  @XmlEnumValue("MACKEREL")
  VALUE_101("MACKEREL"),
  @XmlEnumValue("MAHI_MAHI")
  VALUE_102("MAHI_MAHI"),
  @XmlEnumValue("MARLIN")
  VALUE_103("MARLIN"),
  @XmlEnumValue("MELATONIN")
  VALUE_104("MELATONIN"),
  @XmlEnumValue("METHYL_2_OCTYNOATE")
  VALUE_105("METHYL_2_OCTYNOATE"),
  @XmlEnumValue("METHYL_HEPTIN_CARBONATE")
  VALUE_106("METHYL_HEPTIN_CARBONATE"),
  @XmlEnumValue("MILK")
  VALUE_107("MILK"),
  @XmlEnumValue("MOLLUSCS")
  VALUE_108("MOLLUSCS"),
  @XmlEnumValue("MONKFISH_(ANGLERFISH,_LOTTE)")
  VALUE_109("MONKFISH_(ANGLERFISH,_LOTTE)"),
  @XmlEnumValue("MUSSELS")
  VALUE_110("MUSSELS"),
  @XmlEnumValue("MUSTARD")
  VALUE_111("MUSTARD"),
  @XmlEnumValue("NO_DECLARED_ALLERGENS")
  VALUE_112("NO_DECLARED_ALLERGENS"),
  @XmlEnumValue("OAT")
  VALUE_113("OAT"),
  @XmlEnumValue("OCTOPUS")
  VALUE_114("OCTOPUS"),
  @XmlEnumValue("ORANGE_ROUGHY")
  VALUE_115("ORANGE_ROUGHY"),
  @XmlEnumValue("OYSTERS")
  VALUE_116("OYSTERS"),
  @XmlEnumValue("P-METHYLAMINOPHENOL")
  VALUE_117("P-METHYLAMINOPHENOL"),
  @XmlEnumValue("P-PHENYLENEDIAMINE")
  VALUE_118("P-PHENYLENEDIAMINE"),
  @XmlEnumValue("PEANUTS")
  VALUE_119("PEANUTS"),
  @XmlEnumValue("PEAS")
  VALUE_120("PEAS"),
  @XmlEnumValue("PECAN_NUTS")
  VALUE_121("PECAN_NUTS"),
  @XmlEnumValue("PERCH")
  VALUE_122("PERCH"),
  @XmlEnumValue("PERIWINKLE")
  VALUE_123("PERIWINKLE"),
  @XmlEnumValue("PIKE")
  VALUE_124("PIKE"),
  @XmlEnumValue("PILI_NUTS")
  VALUE_125("PILI_NUTS"),
  @XmlEnumValue("PINE_NUTS")
  VALUE_126("PINE_NUTS"),
  @XmlEnumValue("PISTACHIOS")
  VALUE_127("PISTACHIOS"),
  @XmlEnumValue("PLAICE")
  VALUE_128("PLAICE"),
  @XmlEnumValue("POD_FRUITS")
  VALUE_129("POD_FRUITS"),
  @XmlEnumValue("POLLOCK")
  VALUE_130("POLLOCK"),
  @XmlEnumValue("POMPANO")
  VALUE_131("POMPANO"),
  @XmlEnumValue("POPPY_SEEDS")
  VALUE_132("POPPY_SEEDS"),
  @XmlEnumValue("PORGY")
  VALUE_133("PORGY"),
  @XmlEnumValue("PORK")
  VALUE_134("PORK"),
  @XmlEnumValue("PRAWNS")
  VALUE_135("PRAWNS"),
  @XmlEnumValue("PULSES")
  VALUE_136("PULSES"),
  @XmlEnumValue("QUAHAUGS")
  VALUE_137("QUAHAUGS"),
  @XmlEnumValue("QUEENSLAND_NUTS")
  VALUE_138("QUEENSLAND_NUTS"),
  @XmlEnumValue("ROCKFISH")
  VALUE_139("ROCKFISH"),
  @XmlEnumValue("RYE")
  VALUE_140("RYE"),
  @XmlEnumValue("SALICYLATE")
  VALUE_141("SALICYLATE"),
  @XmlEnumValue("SALMON")
  VALUE_142("SALMON"),
  @XmlEnumValue("SARDINE")
  VALUE_143("SARDINE"),
  @XmlEnumValue("SCALLOPS")
  VALUE_144("SCALLOPS"),
  @XmlEnumValue("SEED_PRODUCTS")
  VALUE_145("SEED_PRODUCTS"),
  @XmlEnumValue("SESAME_SEEDS")
  VALUE_146("SESAME_SEEDS"),
  @XmlEnumValue("SHARK")
  VALUE_147("SHARK"),
  @XmlEnumValue("SHEA_NUTS")
  VALUE_148("SHEA_NUTS"),
  @XmlEnumValue("SHELLFISH")
  VALUE_149("SHELLFISH"),
  @XmlEnumValue("SHRIMP")
  VALUE_150("SHRIMP"),
  @XmlEnumValue("SMELT")
  VALUE_151("SMELT"),
  @XmlEnumValue("SNAPPER")
  VALUE_152("SNAPPER"),
  @XmlEnumValue("SOLE")
  VALUE_153("SOLE"),
  @XmlEnumValue("SOYBEANS")
  VALUE_154("SOYBEANS"),
  @XmlEnumValue("SPELT")
  VALUE_155("SPELT"),
  @XmlEnumValue("SQUID_(CALAMARI)")
  VALUE_156("SQUID_(CALAMARI)"),
  @XmlEnumValue("STURGEON")
  VALUE_157("STURGEON"),
  @XmlEnumValue("SULPHUR_DIOXIDE")
  VALUE_158("SULPHUR_DIOXIDE"),
  @XmlEnumValue("SUNFLOWER_SEEDS")
  VALUE_159("SUNFLOWER_SEEDS"),
  @XmlEnumValue("SWORDFISH")
  VALUE_160("SWORDFISH"),
  @XmlEnumValue("TILAPIA")
  VALUE_161("TILAPIA"),
  @XmlEnumValue("TOLUENE-2,5-DIAMINE")
  VALUE_162("TOLUENE-2,5-DIAMINE"),
  @XmlEnumValue("TREE_NUTS")
  VALUE_163("TREE_NUTS"),
  @XmlEnumValue("TREE_NUT_TRACES")
  VALUE_164("TREE_NUT_TRACES"),
  @XmlEnumValue("TRITICALE")
  VALUE_165("TRITICALE"),
  @XmlEnumValue("TROUT")
  VALUE_166("TROUT"),
  @XmlEnumValue("TUNA")
  VALUE_167("TUNA"),
  @XmlEnumValue("TURBOT")
  VALUE_168("TURBOT"),
  @XmlEnumValue("WALLEYE")
  VALUE_169("WALLEYE"),
  @XmlEnumValue("WALNUTS")
  VALUE_170("WALNUTS"),
  @XmlEnumValue("WHEAT")
  VALUE_171("WHEAT"),
  @XmlEnumValue("WHELKS")
  VALUE_172("WHELKS"),
  @XmlEnumValue("WHITEFISH")
  VALUE_173("WHITEFISH"),
  @XmlEnumValue("WHITING")
  VALUE_174("WHITING");
  private final String value;

  AllergenTypeCode(String v) {
    value = v;
  }

  /**
   * Gets the value associated to the enum constant.
   *
   * @return The value linked to the enum.
   */
  public String value() {
    return value;
  }

  /**
   * Gets the enum associated to the value passed as parameter.
   *
   * @param v The value to get the enum from.
   * @return The enum which corresponds to the value, if it exists.
   * @throws IllegalArgumentException If no value matches in the enum declaration.
   */
  public static AllergenTypeCode fromValue(String v) {
    for (AllergenTypeCode c : AllergenTypeCode.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
