package io.openepcis.model.epcis.extension;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.openepcis.model.epcis.XmlSupportExtension;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class OpenEPCISExtension implements CaptureID, EventHashID, EventSequence {
    @XmlTransient
    @JsonIgnore
    private String hash;

    @XmlTransient
    @JsonIgnore
    private Integer sequenceInEPCISDoc;

    @XmlTransient
    @JsonIgnore
    private String captureID;

    public OpenEPCISExtension() {}

    @Builder(builderMethodName = "builder")
    public OpenEPCISExtension(final String hash, final Integer sequenceInEPCISDoc, final String captureID) {
        this.hash = hash;
        this.sequenceInEPCISDoc = sequenceInEPCISDoc;
        this.captureID = captureID;
    }
}
