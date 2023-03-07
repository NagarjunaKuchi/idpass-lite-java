package org.idpass.lite.exceptions;

public class InvalidKeyException extends IDPassException {
    public final byte[] key;

    public InvalidKeyException(byte[] key) {
        super();
        this.key = key;
    }
}
