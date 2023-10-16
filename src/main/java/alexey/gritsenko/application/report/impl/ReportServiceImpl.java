package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.report.InvoiceHeader;
import alexey.gritsenko.application.report.TableStringUtils;
import alexey.gritsenko.application.repository.InvoiceRepository;

import java.util.Scanner;

public class ReportServiceImpl implements Service {
    private static final int PRODUCT_NAME_COLUMN_LENGTH = 20;
    private static final int PRODUCT_COST_COLUMN_LENGTH = 10;
    private final InvoiceRepository invoiceRepository;
    private final TableStringUtils tableStringUtils;
    private final InvoiceHeader invoiceHeader;

    public ReportServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
        this.tableStringUtils = new TableStringUtilsImpl();
        this.invoiceHeader = new InvoiceHeaderImpl(PRODUCT_NAME_COLUMN_LENGTH,PRODUCT_COST_COLUMN_LENGTH,tableStringUtils);

    }

    @Override
    public void doWork(Scanner scanner) {
        String[] invoice = invoiceHeader.getHeader();
        print(invoice);
    }

    private void print(String[] invoice){
        for (String s : invoice) {
            System.out.println(s);
        }
    }
}
