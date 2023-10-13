package application.invoice.impl;

import application.Service;
import application.invoice.InvoiceItemWorker;
import application.repository.InvoiceRepository;

import java.util.Scanner;


public class InvoiceServiceImpl implements Service {
    private final InvoiceRepository repository;
    private static final String ADD_PRODUCT = "Для добавления еще одного продукта нажмите Enter. Для завершения ввода введите 'завершить'";
    private static final String EXIT_COMMAND = "завершить";

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void doWork(Scanner scanner) {
        InvoiceItemWorker worker = new InvoiceItemWorkerImpl();
        while (true) {
            repository.addItemToInvoice(worker.createInvoiceItem(scanner));
            System.out.println(ADD_PRODUCT);
            scanner.next();
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase(EXIT_COMMAND)) {
                    break;
                }

        }
    }
}
