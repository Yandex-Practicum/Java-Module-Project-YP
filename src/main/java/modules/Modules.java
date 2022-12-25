package modules;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Products;

public class Modules {
    final static Scanner scanner = new Scanner(System.in);

    /* Вводим количество человек/гостей (целое положительное число, больше 1)*/
    public static int getCountPeople(){
        int countPeople;
        do {
            System.out.print(" На сколько человек разделить счёт (должно быть целое число > 1) : \n");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Ошибка. Введите целое число больше 1. \n");
                scanner.next();
            }
            countPeople = scanner.nextInt();
            if (countPeople < 2){
                System.out.println("\n Ошибка. Введенное значение < 2 \n");
            }
        } while (countPeople <= 1);
        System.out.println("\n Значит делим счёт на " + countPeople + " ");
        return countPeople;
    }

    /* Создание списка товаров */
    public static ArrayList<Products> getAddProductsFromUser(){
        String name;
        double price;
        String command;
        ArrayList<Products> products = new ArrayList<>();// для записи результата
        /* Команда для входа в цикл по заполнению списка товаров */
        System.out.println("\n Конструктор списка товаров. \n " +
                " Для добавления товара введите команду \"Добавить\" \n " +
                " или \"Завершить\" для завершения добавления товаров : \n");
        command = scanner.next();
        /* Цикл заполнения списка товаров */
        while (!command.isEmpty()) {
            if (command.equalsIgnoreCase("Добавить")) {
                /* Наименование товара */
                System.out.println("\n Введите наименование товара (любое значение, кроме \" \"): \n");
                name = scanner.next();
                /* Цена товара */
                System.out.println("\n Введите цену товара (в консоли числа типа float, double вводим через запятую - 1,7; 2,7 и т.д.): \n");
                do {
                    while (!scanner.hasNextDouble()) {
                        System.out.println("\n Ошибка. Введите число >= 0 \n");
                        scanner.next();
                    }
                    price = scanner.nextDouble();
                    if (price <= 0.00f){
                        System.out.println("\n Ошибка. Введенное значение <= 0 \n");
                    }
                } while (price <= 0.00f);
                /* Добавление товара в список и вывод добавленного элемента на консоль */
                Products product = new Products(name, price);//, count
                products.add(product);
                System.out.printf("\n Товар : \n Название = %s \n Цена = %.2f \n\n Товар добавлен успешно ! \n", name, price);
                System.out.println("\n Хотите ли добавить еще один товар ? ");
                /* Запрос команды для взаимодействия с циклом заполнения списка товаров */
                System.out.println("\n Конструктор списка товаров. \n " +
                        " Для добавления товара введите команду \"Добавить\" \n " +
                        " или \"Завершить\" для завершения добавления товаров : \n");
                command = scanner.next();
                /* Завершение работы с циклом заполнения списка товаров */
            } else if (command.equalsIgnoreCase("Завершить")) {
                break;
                /* Введена не корректная команда */
            } else {
                System.out.println("\n Вы ввели \" " + command + " \" ничего не происходит. \n" +
                        " Введите команду \"Добавить\" или \"Завершить\" : \n");
                command = scanner.next();
            }
        }
        /* Выход из цикла и отправление возвращаемого значения в Main*/
        return products;
    }

    /* Распаковка результата */
    public static void makeResult(ArrayList<Products> products, int countPeople){
        /* Вывод списка товаров и подсчет общей стоимости */
        double sumPriceProducts = 0;
        System.out.println("\n СПИСОК ДОБАВЛЕННЫХ ТОВАРОВ : ");
        for (Products prod: products) {
            sumPriceProducts = sumPriceProducts + prod.getPrice();
            if (prod.getPrice() < 2 && prod.getPrice() >= 1) {
                System.out.printf("\n Добавленные товары : \n Название : %s;    Цена : %.2f рубль", prod.getName(), prod.getPrice());
            }else if ((prod.getPrice() < 5 && prod.getPrice() >= 2) || (prod.getPrice() < 1 && prod.getPrice() >= 0)){
                System.out.printf("\n Добавленные товары : \n Название : %s;    Цена : %.2f рубля", prod.getName(), prod.getPrice());
            } else if (prod.getPrice() > 4){
                System.out.printf("\n Добавленные товары : \n Название : %s;    Цена : %.2f рублей", prod.getName(), prod.getPrice());
            } else if (prod.getPrice() > 4){
                System.out.printf("\n Добавленные товары : \n Название : %s;    Цена : %.2f копеек", prod.getName(), prod.getPrice());
            }
        }
        /* Вывод результата */
        if (sumPriceProducts/countPeople < 2 && sumPriceProducts/countPeople >= 1) {
            System.out.printf("\n\n Каждый из %d друзей должен заплатить по %.2f рубль. \n", countPeople, sumPriceProducts/countPeople);
        } else if ((sumPriceProducts/countPeople < 5 && sumPriceProducts/countPeople >= 2) || (sumPriceProducts/countPeople < 1 && sumPriceProducts/countPeople >= 0)) {
            System.out.printf("\n\n Каждый из %d друзей должен заплатить по %.2f рубля. \n", countPeople, sumPriceProducts/countPeople);
        } else if (sumPriceProducts/countPeople > 4){
            System.out.printf("\n\n Каждый из %d друзей должен заплатить по %.2f рублей. \n", countPeople, sumPriceProducts/countPeople);
        } else if (sumPriceProducts/countPeople >= 0 && sumPriceProducts/countPeople < 1){
            System.out.printf("\n\n Каждый из %d друзей должен заплатить по %.2f копеек. \n", countPeople, sumPriceProducts/countPeople);
        }
    }
}
