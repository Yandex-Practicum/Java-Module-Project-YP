package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.invoice.InvoiceItemWorker;
import alexey.gritsenko.application.repository.InvoiceRepository;

import java.util.Scanner;


public class InvoiceServiceImpl implements Service {
    private final InvoiceRepository repository;
    private static final String ADD_PRODUCT = "Для добавления еще одного продукта введите любую строку. Для завершения ввода введите 'завершить'";
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
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase(EXIT_COMMAND)) {
                    break;
                }
        }
    }
}
