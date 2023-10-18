package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.invoice.InvoiceItemWorker;
import alexey.gritsenko.application.repository.InvoiceRepository;

import java.util.Scanner;


public class InvoiceServiceImpl implements Service {
    private final InvoiceRepository repository;
    private static final String ADD_PRODUCT_OR_EXIT = "Для добавления еще одного продукта введите любую строку. Для завершения ввода введите 'завершить'";
    private static final String EXIT_COMMAND = "завершить";
    private final ProductNameValidator productNameValidator;
    private final ProductCostValidator productCostValidator;

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
        productNameValidator = new ProductNameValidator();
        productCostValidator = new ProductCostValidator();
    }

    @Override
    public void doWork(Scanner scanner) {
        InvoiceItemWorker worker = new InvoiceItemWorkerImpl(productNameValidator, productCostValidator);
        while (true) {
            repository.addItemToInvoice(worker.createInvoiceItem(scanner));
            System.out.println(ADD_PRODUCT_OR_EXIT);
                String response = scanner.next();
                if (response.equalsIgnoreCase(EXIT_COMMAND)) {
                    break;
                }
        }
    }
}
