package application.invoice.impl;

import application.invoice.InvoiceItemWorker;
import application.models.InvoiceItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InvoiceItemWorkerImpl implements InvoiceItemWorker {
    private static final String INPUT_PRODUCT_NAME = "Введите наименование товара";
    private static final String INPUT_PRODUCT_COST = "Введите стоимость товара";
    private static final String INPUT_COST_ERROR = "Введена некорректная стоимость";
    private static final String INPUT_PRODUCT_ERROR = "Введена пустая строка";
    private static final String ADD_PRODUCT_SUCCESS = "Продукт успешно добавлен";



    @Override
    public InvoiceItem createInvoiceItem(Scanner scanner) {

        String  productName = inputProductName(scanner);
        double cost;
        do {
            cost = inputProductCost(scanner);
        } while (!(cost > 0));

        System.out.println(ADD_PRODUCT_SUCCESS);
        return new InvoiceItem(productName, cost);
    }

    private String inputProductName(Scanner scanner){
        System.out.println(INPUT_PRODUCT_NAME);
        scanner.next();
        while (!scanner.hasNextLine()){
            System.out.println(INPUT_PRODUCT_ERROR);
            scanner.next();
        }
        return scanner.nextLine();
    }

    private double inputProductCost(Scanner scanner){
        System.out.println(INPUT_PRODUCT_COST);
        while (!scanner.hasNextDouble()){
            System.out.println(INPUT_COST_ERROR);
            scanner.next();
        }
        BigDecimal rawCost = BigDecimal.valueOf(scanner.nextDouble()).setScale(2, RoundingMode.HALF_DOWN);
        return rawCost.doubleValue();
    }
}
