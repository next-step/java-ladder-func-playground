package exception;

public class InvalidPrizeException extends IllegalArgumentException {

    public InvalidPrizeException(String message) {
        super(message);
    }
}
