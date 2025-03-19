package io.openepcis.core.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
  public ResourceAlreadyExistsException(String msg) {
    super(msg);
  }

  public ResourceAlreadyExistsException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
