package com.example.clinicaveterinaria.excepcion;

public class ExcepcionDAO extends Exception{

    public ExcepcionDAO() {
    }

    public ExcepcionDAO(String message) {
        super(message);
    }

    public ExcepcionDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionDAO(Throwable cause) {
        super(cause);
    }

    public ExcepcionDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
