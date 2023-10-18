package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.invoice.InvoiceItemWorker;
import alexey.gritsenko.application.models.InvoiceItem;


import java.util.Scanner;

public class InvoiceItemWorkerImpl implements InvoiceItemWorker {
    private static final String INPUT_PRODUCT_NAME = "Введите наименование товара";
    private static final String INPUT_PRODUCT_COST = "Введите стоимость товара";
    private static final String INPUT_COST_ERROR = "Введена некорректная стоимость. Введите в формате рубли.копейки (2 знака после точки)";
    private static final String INPUT_PRODUCT_ERROR = "Введена некорректное наименование товара. Допускаются только буквы русского или латинского алфавита";
    private static final String ADD_PRODUCT_SUCCESS = "Успешно добавлен";

    private final ProductNameValidator productNameValidator;
    private final ProductCostValidator productCostValidator;

    public InvoiceItemWorkerImpl(ProductNameValidator productNameValidator,
                                 ProductCostValidator productCostValidator) {
        this.productNameValidator = productNameValidator;
        this.productCostValidator = productCostValidator;
    }

    @Override
    public InvoiceItem createInvoiceItem(Scanner scanner) {
        String productName=inputProductName(scanner);
        double cost = inputProductCost(scanner);

        InvoiceItem item = new InvoiceItem(productName, cost);
        System.out.println(ADD_PRODUCT_SUCCESS+ item);
        return item;
    }

    private String inputProductName(Scanner scanner){
        System.out.println(INPUT_PRODUCT_NAME);
        String productName;
        while (true){
                productName=scanner.next();
                if(this.productNameValidator.isValid(productName)){
                    break;
                }
                System.out.println(INPUT_PRODUCT_ERROR);
                System.out.println(INPUT_PRODUCT_NAME);


        }
        return productName.strip();
    }

    private double inputProductCost(Scanner scanner){
        String cost;
        System.out.println(INPUT_PRODUCT_COST);
        while (true){
            if(scanner.hasNextDouble()){
                //к строке потому что если второй знак после запятой 0 он обрезается
                // и не проходит валидацию по формату ввода
                //например 523.30 nextDouble() выдаст в лучшем случае 523.3 без 0
                cost = scanner.next();
                if (this.productCostValidator.isValid(cost)){
                    break;
                }else {
                    System.out.println(INPUT_COST_ERROR);
                    System.out.println(INPUT_PRODUCT_COST);
                }
            }else {
                scanner.next();
            }
        }
        return Double.parseDouble(cost);
    }

}
