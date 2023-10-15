package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.InvoiceHeader;

public class InvoiceHeaderImpl implements InvoiceHeader {
    private static final int LENGTH_PRODUCT_NAME_COLUMN = 15;
    private static final int LENGTH_PRODUCT_COST_COLUMN = 7;
    private static final String PRODUCT_NAME_COLUMN = "Наименование";
    private static final String PRODUCT_COST_COLUMN = "Стоимость";

    @Override
    public String[] getHeader() {
        String firstAndLastLine ="*".repeat(1+LENGTH_PRODUCT_NAME_COLUMN+1+LENGTH_PRODUCT_COST_COLUMN+1);

        //пытаемся разместить посередине
        // если длина имени колонки больше длины колонки переносим на следующую строку

        return null;

    }

}
