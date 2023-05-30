package org.example.exception;

public class ElementISFUllException extends RuntimeException {
    public ElementISFUllException() {
    }

    public ElementISFUllException(String message) {
        super(message);
    }

    public ElementISFUllException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementISFUllException(Throwable cause) {
        super(cause);
    }

    public ElementISFUllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
