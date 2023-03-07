package org.idpass.lite.exceptions;

public class InvalidCardException extends IDPassException {
    public InvalidCardException(String s) {
        super(s);
    }

    public InvalidCardException() {
        super();
    }
}
