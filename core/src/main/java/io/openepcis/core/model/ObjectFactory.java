package io.openepcis.core.model;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
  private ObjectFactory() {}

  public static PaginationSupport createPaginationSupport() {
    return new PaginationSupport();
  }
}
