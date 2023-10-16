package alexey.gritsenko.application.invoice.impl;

import alexey.gritsenko.application.invoice.InvoiceItemWorker;
import alexey.gritsenko.application.models.InvoiceItem;


import java.util.Scanner;
import java.util.regex.Pattern;

public class InvoiceItemWorkerImpl implements InvoiceItemWorker {
    private static final String INPUT_PRODUCT_NAME = "Введите наименование товара";
    private static final String INPUT_PRODUCT_COST = "Введите стоимость товара";
    private static final String INPUT_COST_ERROR = "Введена некорректная стоимость. Введите в формате рубли.копейки (2 знака после точки)";
    private static final String INPUT_PRODUCT_ERROR = "Введена некорректное наименование товара. Допускаются только буквы русского или латинского алфавита";
    private static final String ADD_PRODUCT_SUCCESS = "Продукт успешно добавлен";
    //Строка должна соответствовать формату рубли.копейки
    private static final String CHECK_PRODUCT_COST_REGEXP = "^\\d+\\.\\d{2}+$";

    //Строка должна содержать только буквы русского или латинского алфавита
    private static final String CHECK_PRODUCT_NAME_REGEXP = "[A-Za-z\\u0401\\u0451\\u0410-\\u044f]+";



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
        do{
            productName=scanner.nextLine();
        }while (!validateProductName(productName));
        return productName.strip();
    }

    private double inputProductCost(Scanner scanner){
        System.out.println(INPUT_PRODUCT_COST);
        String cost;
        do{
            cost=scanner.nextLine();
        }while (!validateProductCost(cost));
        return Double.parseDouble(cost);
    }

    private boolean validateProductName(String productName){
        if(productName==null||productName.isBlank()){
            return false;
        }

        if(!Pattern.matches(CHECK_PRODUCT_NAME_REGEXP,productName)){
            System.out.println(INPUT_PRODUCT_ERROR);
            System.out.println(INPUT_PRODUCT_NAME);
            return false;
        }
        return true;
    }

    private boolean validateProductCost(String cost){
        if(!Pattern.matches(CHECK_PRODUCT_COST_REGEXP, cost)){
            System.out.println(INPUT_COST_ERROR);
            System.out.println(INPUT_PRODUCT_COST);
            return false;
        }
        return true;
    }
}
