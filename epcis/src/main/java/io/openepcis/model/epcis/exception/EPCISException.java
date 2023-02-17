/*
 * Copyright 2022 benelog GmbH & Co. KG
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

public class EPCISException extends RuntimeException {

  private final int status;

  private EPCISException(String msg) {
    super(msg);
    this.status = 500;
  }

  public EPCISException(String msg, int status) {
    super(msg);
    this.status = status;
  }

  private EPCISException(String msg, Throwable cause) {
    super(msg, cause);
    this.status = 500;
  }

  public EPCISException(String msg, int status, Throwable cause) {
    super(msg, cause);
    this.status = status;
  }

  public int getStatus() {
    return this.status;
  }
}
