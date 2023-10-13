package application.invoice;

import application.models.InvoiceItem;

import java.util.Scanner;

public interface InvoiceItemWorker {
    InvoiceItem createInvoiceItem(Scanner scanner);
}
