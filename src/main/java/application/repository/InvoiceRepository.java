package application.repository;

import application.models.InvoiceItem;

public interface InvoiceRepository {
    void saveCountVisitors(int visitors);
    int getCountVisitors();
    void addItemToInvoice(InvoiceItem item);
    double getInvoiceCost();
}
