package com.ol.exceptions;

public class CapteurNonTrouveException extends Exception{

	public CapteurNonTrouveException() {
    }

    public CapteurNonTrouveException(String message) {
        super(message);
    }

    public CapteurNonTrouveException(String message, Throwable cause) {
        super(message, cause);
    }

    public CapteurNonTrouveException(Throwable cause) {
        super(cause);
    }

    public CapteurNonTrouveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
