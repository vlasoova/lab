package exceptions;

public class AlreadyDeadException extends RuntimeException {
    public AlreadyDeadException(String message) {
        super(message);
    }
}
