package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.StringValueValidator;

import java.util.regex.Pattern;

public class ProductCostValidator implements StringValueValidator {
    //Строка должна соответствовать формату рубли.копейки например 22.00
    private static final String CHECK_PRODUCT_COST_REGEXP = "^\\d+\\.\\d{2}+$";
    @Override
    public boolean isValid(String cost) {
        return (!(Double.parseDouble(cost) <= 0)) && Pattern.matches(CHECK_PRODUCT_COST_REGEXP, cost);
    }
}
