package alexey.gritsenko.application.repository;

import alexey.gritsenko.application.models.InvoiceItem;

public interface RepositoryEngine {
    void add(InvoiceItem item);
    InvoiceItem[] getArray();
}
