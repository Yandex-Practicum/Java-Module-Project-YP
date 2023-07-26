package exceptions;

public class PersonsOnlyException extends PersonstQuantityException{
    public PersonsOnlyException(String message) {
        super(message);
    }
}
