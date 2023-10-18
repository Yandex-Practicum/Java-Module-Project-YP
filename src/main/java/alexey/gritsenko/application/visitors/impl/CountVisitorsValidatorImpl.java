package alexey.gritsenko.application.visitors.impl;

import alexey.gritsenko.application.IntegerValueValidator;

public class CountVisitorsValidatorImpl implements IntegerValueValidator {
    @Override
    public boolean isValid(int countVisitors) {
        return countVisitors>1;
    }

}
