/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
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
package io.openepcis.model.interfaces;

import io.openepcis.model.gs1webvocab.ReferencedFileTypeCode;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface ReferencedFileDetails<QV extends QuantitativeValue> {
  String getFileLanguageCode();

  void setFileLanguageCode(String value);

  BigInteger getFilePixelHeight();

  void setFilePixelHeight(BigInteger value);

  BigInteger getFilePixelWidth();

  void setFilePixelWidth(BigInteger value);

  LocalDateTime getReferencedFileEffectiveEndDateTime();

  void setReferencedFileEffectiveEndDateTime(LocalDateTime value);

  LocalDateTime getReferencedFileEffectiveStartDateTime();

  void setReferencedFileEffectiveStartDateTime(LocalDateTime value);

  QV getReferencedFileSize();

  void setReferencedFileSize(QV value);

  ReferencedFileTypeCode getReferencedFileType();

  void setReferencedFileType(ReferencedFileTypeCode value);

  String getReferencedFileURL();

  void setReferencedFileURL(String value);
}
