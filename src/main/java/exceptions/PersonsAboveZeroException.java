package exceptions;

public class PersonsAboveZeroException extends PersonstQuantityException {
    public PersonsAboveZeroException(String message) {
        super(message);
    }
}
