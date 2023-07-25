package exceptions;

import utils.Consts;

public class PriceInputException extends RuntimeException {
    public PriceInputException() {
        super(Consts.INCORRECT_PROMT);
    }
}
