import application.InvoiceCalculator;
import application.InvoiceCalculatorImpl;

public class Main {
    public static void main(String[] args) {
        InvoiceCalculator invoiceCalculator = new InvoiceCalculatorImpl();
        invoiceCalculator.start();
    }
}