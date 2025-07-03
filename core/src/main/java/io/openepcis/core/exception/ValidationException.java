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

public class ValidationException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;

  public ValidationException() {
    super();
  }

  public ValidationException(
      final String message,
      final Throwable cause,
      final boolean enableSuppression,
      final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ValidationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ValidationException(final String message) {
    super(message);
  }

  public ValidationException(final Throwable cause) {
    super(cause);
  }
}
