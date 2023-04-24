package service.impl;

import java.util.List;
import java.util.Scanner;

import model.Product;
import service.InvoiceCalculatorService;
import util.Formatter;

public class InvoiceCalculatorServiceImpl implements InvoiceCalculatorService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int chooseNumberOfPeopleNeedToSplitBill() {
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (SCANNER.hasNextInt()) {
                int counterPeople = SCANNER.nextInt();
                if (counterPeople < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                    continue;
                } else if (counterPeople == 1) {
                    System.out.println("Нет смысла ничего считать и делить");
                    continue;
                }
                return counterPeople;
            } else {
                System.out.println("Ошибка: введите число.");
                SCANNER.next();
            }
        }
    }
    @Override
    public void calculateTheAmountForEachPerson(int counterPeople, List<Product> productList) {
        System.out.println("Добавленные товары: ");
        productList.stream()
                .map(Product::getProductName)
                .forEach(System.out::println);

        //Тут из коллекции Product достаем только priceProduct
        List<Double> priceList = productList
                .stream()
                .map(Product::getPrice)
                .map(Double.class::cast)
                .toList();

        //Тут из коллекции List<Double>(priceProduct) считаем итоговую сумму товаров
        double totalAmount = priceList
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        double priceForEach = totalAmount / counterPeople;
        String result = Formatter.formatAmount(priceForEach);

        System.out.printf("Вы хотели разделить счет на %d человек. С каждого к оплате: %s", counterPeople, result);
    }


}



