package application.visitors.impl;

import application.visitors.CountVisitorValidator;

public class CountVisitorValidatorImpl implements CountVisitorValidator {
    @Override
    public boolean isValid(int countVisitors) {
        return countVisitors>1;
    }
}
