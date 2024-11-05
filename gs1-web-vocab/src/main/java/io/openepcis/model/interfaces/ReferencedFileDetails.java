package io.openepcis.model.interfaces;

public interface ReferencedFileDetails<QV extends QuantitativeValue> {
    String getFileLanguageCode();

    void setFileLanguageCode(String value);

    String getFilePixelHeight();

    void setFilePixelHeight(String value);

    String getFilePixelWidth();

    void setFilePixelWidth(String value);

    String getReferencedFileEffectiveEndDateTime();

    void setReferencedFileEffectiveEndDateTime(String value);

    String getReferencedFileEffectiveStartDateTime();

    void setReferencedFileEffectiveStartDateTime(String value);

    QV getReferencedFileSize();

    void setReferencedFileSize(QV value);

    String getReferencedFileType();

    void setReferencedFileType(String value);

    String getReferencedFileURL();

    void setReferencedFileURL(String value);
}
