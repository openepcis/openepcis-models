package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.MaturationMethodCode;
import io.openepcis.model.gs1webvocab.NonbinaryLogicCode;

public interface FruitsVegetables {
    NonbinaryLogicCode getIsPittedStoned();

    void setIsPittedStoned(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsSeedless();

    void setIsSeedless(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsShelledPeeled();

    void setIsShelledPeeled(NonbinaryLogicCode value);

    NonbinaryLogicCode getIsWashedReadyToEat();

    void setIsWashedReadyToEat(NonbinaryLogicCode value);

    MaturationMethodCode getMaturationMethod();

    void setMaturationMethod(MaturationMethodCode value);
}
