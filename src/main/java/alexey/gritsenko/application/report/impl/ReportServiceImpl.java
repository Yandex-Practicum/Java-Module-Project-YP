package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.repository.InvoiceRepository;

import java.util.Scanner;

public class ReportServiceImpl implements Service {
    private final InvoiceRepository invoiceRepository;

    public ReportServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void doWork(Scanner scanner) {

    }
}
