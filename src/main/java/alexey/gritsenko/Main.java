package alexey.gritsenko;

import alexey.gritsenko.application.InvoiceCalculator;
import alexey.gritsenko.application.InvoiceCalculatorImpl;

public class Main {
    public static void main(String[] args) {
        InvoiceCalculator invoiceCalculator = new InvoiceCalculatorImpl();
        invoiceCalculator.createContext().start();
    }
}