/*
 * Copyright (c) 2022-2025 benelog GmbH & Co. KG
 * All rights reserved.
 *
 * Unauthorized copying, modification, distribution,
 * or use of this work, via any medium, is strictly prohibited.
 *
 * benelog GmbH & Co. KG reserves all rights not expressly granted herein,
 * including the right to sell licenses for using this work.
 */
package io.openepcis.core.exception;

import java.io.Serial;

public class UnsupportedGS1IdentifierException extends ValidationException {

  @Serial private static final long serialVersionUID = 1L;

  public UnsupportedGS1IdentifierException() {}

  public UnsupportedGS1IdentifierException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public UnsupportedGS1IdentifierException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnsupportedGS1IdentifierException(String message) {
    super(message);
  }

  public UnsupportedGS1IdentifierException(Throwable cause) {
    super(cause);
  }
}
