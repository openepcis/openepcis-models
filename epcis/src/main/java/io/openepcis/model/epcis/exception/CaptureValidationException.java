/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package io.openepcis.model.epcis.exception;

public class CaptureValidationException extends RuntimeException {

  public CaptureValidationException() {
    super();
  }

  public CaptureValidationException(
          String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public CaptureValidationException(Throwable cause) {
    super(cause);
  }

  public CaptureValidationException(String msg) {
    super(msg);
  }

  public CaptureValidationException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public static final CaptureValidationException of(String msg, Throwable cause) {
    if (CaptureValidationException.class.isAssignableFrom(cause.getClass())) {
      return (CaptureValidationException) cause;
    }
    return new CaptureValidationException(msg, cause);
  }

}
