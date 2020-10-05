package com.ol.exceptions;

public class MesuresNonTrouveException extends Exception{

	public MesuresNonTrouveException() {
    }

    public MesuresNonTrouveException(String message) {
        super(message);
    }

    public MesuresNonTrouveException(String message, Throwable cause) {
        super(message, cause);
    }

    public MesuresNonTrouveException(Throwable cause) {
        super(cause);
    }

    public MesuresNonTrouveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
