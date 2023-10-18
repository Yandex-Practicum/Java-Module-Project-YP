package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.InvoiceFormGenerator;
import alexey.gritsenko.application.report.TableStringUtils;
import alexey.gritsenko.application.repository.InvoiceRepository;

public class InvoiceBottomFormGenerator implements InvoiceFormGenerator {
    private static final String TOTAL_COST = "Итого по счету: ";
    private static final String COUNT_VISITORS = "Количество посетителей: ";
    private static final String PAY_TO_PERSON = "Каждый должен заплатить ";
    private final TableStringUtils tableStringUtils;
    private final InvoiceRepository invoiceRepository;

    public InvoiceBottomFormGenerator(TableStringUtils tableStringUtils, InvoiceRepository invoiceRepository) {
        this.tableStringUtils = tableStringUtils;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public String[] getPartForm() {
       double cost = this.invoiceRepository.getInvoiceCost();
       int visitors = this.invoiceRepository.getCountVisitors();
       String[] result = new String[3];
       String costToString = this.tableStringUtils.costToString(String.format("%.2f",cost));
       String invoiceCost = TOTAL_COST+costToString;
       result[0] = invoiceCost+";";
       result[1] = COUNT_VISITORS+visitors+";";
       String pay = this.tableStringUtils.costToString(String.format("%.2f",cost/visitors));
       result[2] = PAY_TO_PERSON+ pay;
       return result;
    }
}
