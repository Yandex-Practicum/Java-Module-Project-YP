package alexey.gritsenko.application.visitors.impl;

import alexey.gritsenko.application.visitors.CountVisitorValidator;

public class CountVisitorValidatorImpl implements CountVisitorValidator {
    @Override
    public boolean isValid(int countVisitors) {
        return countVisitors>1;
    }
}
