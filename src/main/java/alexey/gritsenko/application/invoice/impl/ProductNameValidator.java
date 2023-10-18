package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.StringValueValidator;

import java.util.regex.Pattern;

public class ProductNameValidator implements StringValueValidator {
    //Строка должна содержать только буквы русского или латинского алфавита
    private static final String CHECK_PRODUCT_NAME_REGEXP = "[A-Za-z\\u0401\\u0451\\u0410-\\u044f]+";
    @Override
    public boolean isValid(String productName) {
        if(productName==null||productName.isBlank()){
            return false;
        }
        return Pattern.matches(CHECK_PRODUCT_NAME_REGEXP, productName);
    }

}
