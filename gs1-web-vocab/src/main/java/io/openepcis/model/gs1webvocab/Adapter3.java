//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package io.openepcis.model.gs1webvocab;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Year;

public class Adapter3 extends XmlAdapter<String, Year> {

  public Year unmarshal(String value) {
    return (Year.parse(value));
  }

  public String marshal(Year value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }
}
