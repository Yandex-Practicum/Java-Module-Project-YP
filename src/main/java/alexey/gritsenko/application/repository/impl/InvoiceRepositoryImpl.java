package alexey.gritsenko.application.repository.impl;

import alexey.gritsenko.application.models.InvoiceItem;
import alexey.gritsenko.application.repository.InvoiceRepository;
import alexey.gritsenko.application.repository.RepositoryEngine;



public class InvoiceRepositoryImpl implements InvoiceRepository {
    private final RepositoryEngine invoiceItems = new RepositoryEngineImpl();
    private double invoiceCost;
    private int countVisitors;

    @Override
    public void saveCountVisitors(int visitors) {
        this.countVisitors = visitors;
    }

    @Override
    public void addItemToInvoice(InvoiceItem item){
        this.invoiceCost= this.invoiceCost+item.cost();
        this.invoiceItems.add(item);
    }

    @Override
    public InvoiceItem[] getArrayItems() {
        return this.invoiceItems.getArray();
    }

    @Override
    public double getInvoiceCost(){
        return this.invoiceCost;
    }

    @Override
    public int getCountVisitors() {
        return countVisitors;
    }


}
