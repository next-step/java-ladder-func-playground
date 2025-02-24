package exception;

public class InvalidPlayerNameException extends IllegalArgumentException {

    public InvalidPlayerNameException(String message) {
        super(message);
    }
}
