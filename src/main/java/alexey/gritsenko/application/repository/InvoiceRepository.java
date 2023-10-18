package alexey.gritsenko.application.repository;

import alexey.gritsenko.application.models.InvoiceItem;



public interface InvoiceRepository {
    void saveCountVisitors(int visitors);
    int getCountVisitors();
    void addItemToInvoice(InvoiceItem item);
    InvoiceItem[] getArrayItems();
    double getInvoiceCost();
}
