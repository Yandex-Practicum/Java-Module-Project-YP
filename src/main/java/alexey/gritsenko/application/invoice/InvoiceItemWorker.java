package alexey.gritsenko.application.invoice;

import alexey.gritsenko.application.models.InvoiceItem;

import java.util.Scanner;

public interface InvoiceItemWorker {
    InvoiceItem createInvoiceItem(Scanner scanner);
}
