package org.example.exception;

public class StringListIndexOutOfBoundsException extends RuntimeException {
    public StringListIndexOutOfBoundsException() {
    }

    public StringListIndexOutOfBoundsException(String message) {
        super(message);
    }

    public StringListIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringListIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public StringListIndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
