package com.example.clinicaveterinaria.excepcion;

public class ExcepcionMGR extends Exception {
    public ExcepcionMGR() {
    }

    public ExcepcionMGR(String message) {
        super(message);
    }

    public ExcepcionMGR(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionMGR(Throwable cause) {
        super(cause);
    }

    public ExcepcionMGR(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
