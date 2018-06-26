package aps.domain.exception;

public class ApsException extends Exception {
    public ApsException() {

    }

    public ApsException(String message) {
        super(message);
    }

    public ApsException(Throwable cause) {
        super(cause);
    }

    public ApsException(String message, Throwable cause) {
        super(message, cause);
    }
}
