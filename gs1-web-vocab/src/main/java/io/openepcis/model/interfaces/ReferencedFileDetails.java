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
