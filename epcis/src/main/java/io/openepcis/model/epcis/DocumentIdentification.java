package io.openepcis.model.epcis;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.openepcis.model.epcis.modifier.CustomInstantAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "DocumentIdentification",
    namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
    propOrder = {
      "standard",
      "typeVersion",
      "instanceIdentifier",
      "type",
      "multipleType",
      "creationDateAndTime"
    })
public class DocumentIdentification {

  @XmlElement(
      name = "Standard",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String standard;

  @XmlElement(
      name = "TypeVersion",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String typeVersion;

  @XmlElement(
      name = "InstanceIdentifier",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String instanceIdentifier;

  @XmlElement(
      name = "Type",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  protected String type;

  @XmlElement(
      name = "MultipleType",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader")
  protected Boolean multipleType;

  @XmlElement(
      name = "CreationDateAndTime",
      namespace = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader",
      required = true)
  @XmlSchemaType(name = "dateTime")
  @XmlJavaTypeAdapter(CustomInstantAdapter.class)
  @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
  protected OffsetDateTime creationDateAndTime;
}
