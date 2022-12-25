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
            System.out.print(" На сколько человек разделить счёт (должно быть целое число > 1) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Ошибка. Введите целое число больше 1. ");
                scanner.next(); // this is important!
            }
            countPeople = scanner.nextInt();
            if (countPeople < 2){
                System.out.println("\n Ошибка. Введенное значение < 2");
            }
        } while (countPeople <= 1);
        System.out.println("\n Значит делим счёт на " + countPeople + " ");
        return countPeople;
    }

    /* Создание списка товаров */
    public static ArrayList<Products> getAddProductsFromUser(){
        String name;
        double price;
        int count;
        int sumAllProductsCount = 0;
        double sumAllProductsPrice = 0;
        double sumPrice = 0;
        String command;
        ArrayList<Products> products = new ArrayList<>();// для записи результата
        /* Команда для входа в цикл по заполнению списка товаров */
        System.out.println("\n Конструктор списка товаров. \n " +
                " Для добавления товара введите команду \"Добавить\" \n " +
                " или \"Завершить\" для завершения добавления товаров : ");
        command = scanner.next();
        /* Цикл заполнения списка товаров */
        while (!command.isEmpty()) {
            if (command.equalsIgnoreCase("Добавить")) {
                /* Наименование товара */
                System.out.println("\n Введите наименование товара (любое значение): ");
                name = scanner.next();
                /* Цена товара */
                System.out.println("\n Введите цену товара (в консоли числа типа float, double вводим через запятую - 1,7; 2,7 и т.д.): ");
                do {
                    while (!scanner.hasNextDouble()) {
                        System.out.println("\n Ошибка. Введите число >= 0. ");
                        scanner.next(); // this is important!
                    }
                    price = scanner.nextDouble();
                    if (price <= 0.00f){
                        System.out.println("\n Ошибка. Введенное значение <= 0 ");
                    }
                } while (price <= 0.00f);
                /* Количество товара */
                System.out.println("\n Введите количество товара (должно быть целое число >= 1) : ");
                do {
                    while (!scanner.hasNextInt()) {
                        System.out.println("\n Ошибка. Введите целое число >= 1. ");
                        scanner.next(); // this is important!
                    }
                    count = scanner.nextInt();
                    if (count < 1){
                        System.out.println("\n Ошибка. Введенное значение < 1");
                    }
                } while (count <= 0);
                sumAllProductsCount = sumAllProductsCount + count;
                sumAllProductsPrice = sumAllProductsPrice + price;
                sumPrice = sumPrice + ((double) count) * price;
                /* Добавление товара в список и вывод добавленного элемента на консоль */
                Products product = new Products(name, price, count);
                products.add(product);
                System.out.printf("\n Товар : \n Название = %s \n Цена = %.2f \n Количество = %d \n\n Товар добавлен успешно ! \n",name, price, count);
                System.out.println("\n Хотите ли добавить еще один товар ? \n");
                        /* Запрос команды для взаимодействия с циклом заполнения списка товаров */
                System.out.println("\n Конструктор списка товаров. \n " +
                        " Для добавления товара введите команду \"Добавить\" \n " +
                        " или \"Завершить\" для завершения добавления товаров : ");
                command = scanner.next();
                /* Завершение работы с циклом заполнения списка товаров */
            } else if (command.equalsIgnoreCase("Завершить")) {
                break;
                /* Введена не корректная команда */
            } else {
                System.out.println("\n Вы ввели \" " + command + " \" ничего не происходит. \n" +
                        " Введите команду \"Добавить\" или \"Завершить\" : ");
                command = scanner.next();
            }
        }
        System.out.printf("\n Общее количество товаров = %d \n Сумма стоимостей товаров (без учета количества, просто сумма цен добавленных товаров) = %.2f \n Общая цена товаров  = %.2f ", sumAllProductsCount, sumAllProductsPrice, sumPrice);
        /* Выход из цикла и отправление возвращаемого значения в Main*/
        return products;
    }

}
