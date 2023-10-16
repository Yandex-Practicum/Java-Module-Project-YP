package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.InvoiceHeader;
import alexey.gritsenko.application.report.TableStringUtils;

public class InvoiceHeaderImpl implements InvoiceHeader {
    private final int productNameColumnLength;
    private final int productCostColumnLength;
    private final TableStringUtils tableStringUtils;
    private static final String PRODUCT_NAME_COLUMN_TITLE = "Наименование";
    private static final String PRODUCT_COST_COLUMN_TITLE = "Стоимость";

    private static final String INVOICE_TITLE = "Счет";

    public InvoiceHeaderImpl(int productNameColumnLength, int productCostColumnLength, TableStringUtils tableStringUtils) {
        this.productNameColumnLength = productNameColumnLength;
        this.productCostColumnLength = productCostColumnLength;
        this.tableStringUtils = tableStringUtils;
    }


    @Override
    public String[] getHeader() {
        String firstHeaderLine ="*".repeat(1+this.productNameColumnLength+1+this.productCostColumnLength+1);
        int tableWidth = firstHeaderLine.length();
        //пытаемся разместить посередине
        String title = " ".repeat((tableWidth-INVOICE_TITLE.length())/2)+INVOICE_TITLE;
        String[] headerColumnTitle = this.tableStringUtils.createTableString(PRODUCT_NAME_COLUMN_TITLE,
                this.productNameColumnLength,PRODUCT_COST_COLUMN_TITLE,this.productCostColumnLength);
        // если длина имени колонки больше длины колонки переносим на следующую строку
        String[] header = new String[2+headerColumnTitle.length];
        header[0]=title;
        header[1]=firstHeaderLine;
        System.arraycopy(headerColumnTitle,0,header,2,headerColumnTitle.length);
        return header;

    }

}
