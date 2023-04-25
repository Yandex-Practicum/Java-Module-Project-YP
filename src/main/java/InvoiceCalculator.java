import java.util.List;

import model.Product;
import service.InvoiceCalculatorService;
import service.ProductService;
import service.impl.InvoiceCalculatorServiceImpl;
import service.impl.ProductServiceImpl;

public class InvoiceCalculator {
    private final ProductService productService = new ProductServiceImpl();
    private final InvoiceCalculatorService invoiceCalculatorService = new InvoiceCalculatorServiceImpl();

    public void startInvoiceCalculator() {
        int counterPeople = invoiceCalculatorService.chooseNumberOfPeopleNeedToSplitBill();
        List<Product> products = productService.addProductsToTheCalculator();
        invoiceCalculatorService.calculateTheAmountForEachPerson(counterPeople, products);
    }

}



