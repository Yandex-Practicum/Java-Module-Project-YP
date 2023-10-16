package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.report.InvoiceFormGenerator;
import alexey.gritsenko.application.report.TableStringUtils;
import alexey.gritsenko.application.repository.InvoiceRepository;

import java.util.Scanner;

public class ReportServiceImpl implements Service {
    private static final int PRODUCT_NAME_COLUMN_LENGTH = 20;
    private static final int PRODUCT_COST_COLUMN_LENGTH = 10;
    private final InvoiceFormGenerator invoiceHeaderFormGenerator;
    private final InvoiceFormGenerator invoiceBodyFormGenerator;
    private final InvoiceFormGenerator invoiceBottomFormGenerator;

    public ReportServiceImpl(InvoiceRepository invoiceRepository) {
        TableStringUtils tableStringUtils = new TableStringUtilsImpl();
        this.invoiceHeaderFormGenerator = new InvoiceHeaderFormGenerator(PRODUCT_NAME_COLUMN_LENGTH,PRODUCT_COST_COLUMN_LENGTH, tableStringUtils);
        this.invoiceBodyFormGenerator = new InvoiceBodyFormGenerator(PRODUCT_NAME_COLUMN_LENGTH,PRODUCT_COST_COLUMN_LENGTH, tableStringUtils,invoiceRepository);
        this.invoiceBottomFormGenerator = new InvoiceBottomFormGenerator(tableStringUtils,invoiceRepository);
    }

    @Override
    public void doWork(Scanner scanner) {
        String[] invoiceHeader = this.invoiceHeaderFormGenerator.getPartForm();
        String[] invoiceBody = this.invoiceBodyFormGenerator.getPartForm();
        String[] invoiceBottom = this.invoiceBottomFormGenerator.getPartForm();
        print(invoiceHeader);
        print(invoiceBody);
        print(invoiceBottom);
    }

    private void print(String[] invoice){
        for (String s : invoice) {
            System.out.println(s);
        }
    }
}
