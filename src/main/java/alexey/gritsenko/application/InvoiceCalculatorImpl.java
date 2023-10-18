package alexey.gritsenko.application;


import alexey.gritsenko.application.invoice.impl.InvoiceServiceImpl;
import alexey.gritsenko.application.report.impl.ReportServiceImpl;
import alexey.gritsenko.application.repository.InvoiceRepository;
import alexey.gritsenko.application.repository.impl.InvoiceRepositoryImpl;
import alexey.gritsenko.application.visitors.impl.VisitorCountServiceImpl;

import java.util.Locale;
import java.util.Scanner;

public class InvoiceCalculatorImpl implements InvoiceCalculator {
    private static final int COUNT_SERVICE = 3;
    private final Service[] context=new Service[COUNT_SERVICE];

    @Override
    public InvoiceCalculator createContext(){
        InvoiceRepository repository = new InvoiceRepositoryImpl();
        context[0]= new VisitorCountServiceImpl(repository);
        context[1] = new InvoiceServiceImpl(repository);
        context[2] = new ReportServiceImpl(repository);
        return this;
    }

    @Override
    public void start() {
        Scanner scanner =new Scanner(System.in);
        scanner.useLocale(Locale.US);//что бы разделитель дробной части была точка, а не запятая
        for(int i=0; i<COUNT_SERVICE; i++){
            context[i].doWork(scanner);
        }
        scanner.close();
    }


}
