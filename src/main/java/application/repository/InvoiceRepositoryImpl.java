package application.repository;

import application.models.InvoiceItem;

import java.util.LinkedList;
import java.util.List;

public class InvoiceRepositoryImpl implements InvoiceRepository{
    private final List<InvoiceItem> invoiceItems =new LinkedList<>();
    private double invoiceCost;
    private int countVisitors;

    @Override
    public void saveCountVisitors(int visitors) {
        this.countVisitors = visitors;
    }

    @Override
    public void addItemToInvoice(InvoiceItem item){
        this.invoiceCost= this.invoiceCost+item.getCost();
        this.invoiceItems.add(item);
    }

    @Override
    public double getInvoiceCost(){
        return this.invoiceCost;
    }

    public int getCountVisitors() {
        return countVisitors;
    }
}
