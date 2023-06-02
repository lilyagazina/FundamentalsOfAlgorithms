package org.example.exception;


public class ListIndexOutOfBoundsException extends RuntimeException {
    public ListIndexOutOfBoundsException() {
    }

    public ListIndexOutOfBoundsException(String message) {
        super(message);
    }

    public ListIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public ListIndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
