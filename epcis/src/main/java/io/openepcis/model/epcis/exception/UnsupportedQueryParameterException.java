package io.openepcis.model.epcis.exception;

public class UnsupportedQueryParameterException extends EPCISException{
    public UnsupportedQueryParameterException(String msg) {
        super(msg, 501);
    }

    public UnsupportedQueryParameterException(String msg, Throwable cause) {
        super(msg, 501, cause);
    }
}
