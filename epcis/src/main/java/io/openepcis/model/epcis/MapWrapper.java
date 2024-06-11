package io.openepcis.model.epcis;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapWrapper {

  public MapWrapper() {
  }

  @XmlAnyElement
  public List<Object> elements = new ArrayList<>();
}
