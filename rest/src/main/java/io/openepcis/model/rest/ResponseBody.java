package io.openepcis.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(
    name = "ResponseBody",
    factoryClass = ObjectFactory.class,
    factoryMethod = "createResponseBody")
public class ResponseBody {

  @JsonProperty("response")
  @XmlElement
  private String response;
}
