package com.uy.business.proveedor.exception;

public class ProveedorException extends Exception {

    public ProveedorException(){}

    public ProveedorException(String message) {
        super(message);
    }

    public ProveedorException(String message, Throwable cause) {
        super(message, cause);
    }

}
