package application;


import application.invoice.impl.InvoiceServiceImpl;
import application.report.ReportServiceImpl;
import application.repository.InvoiceRepository;
import application.repository.InvoiceRepositoryImpl;
import application.visitors.impl.VisitorCountServiceImpl;

import java.util.Locale;
import java.util.Scanner;

public class InvoiceCalculatorImpl implements InvoiceCalculator {
    @Override
    public void start() {
        Scanner scanner =new Scanner(System.in);
        scanner.useLocale(Locale.US); //что бы разделителем дробной части в double была точка
        InvoiceRepository repository = new InvoiceRepositoryImpl();
        Service visitorService = new VisitorCountServiceImpl(repository);
        Service invoiceService = new InvoiceServiceImpl(repository);
        Service reportService = new ReportServiceImpl(repository);
        visitorService.doWork(scanner);
        invoiceService.doWork(scanner);
        reportService.doWork(scanner);
        scanner.close();
    }
}
