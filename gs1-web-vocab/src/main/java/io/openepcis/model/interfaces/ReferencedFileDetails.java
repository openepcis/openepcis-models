package io.openepcis.model.interfaces;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

public interface ReferencedFileDetails<QV extends QuantitativeValue> {
    String getFileLanguageCode();

    void setFileLanguageCode(String value);

    BigInteger getFilePixelHeight();

    void setFilePixelHeight(BigInteger value);

    BigInteger getFilePixelWidth();

    void setFilePixelWidth(BigInteger value);

    XMLGregorianCalendar getReferencedFileEffectiveEndDateTime();

    void setReferencedFileEffectiveEndDateTime(XMLGregorianCalendar value);

    XMLGregorianCalendar getReferencedFileEffectiveStartDateTime();

    void setReferencedFileEffectiveStartDateTime(XMLGregorianCalendar value);

    QV getReferencedFileSize();

    void setReferencedFileSize(QV value);

    String getReferencedFileType();

    void setReferencedFileType(String value);

    String getReferencedFileURL();

    void setReferencedFileURL(String value);
}
