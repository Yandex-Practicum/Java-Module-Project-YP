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
            System.out.print(" Для разделения счёта, введите значение количества человек/гостей (должно быть целое число > 1) : ");
            while (!scanner.hasNextInt()) {
                System.out.println(" Введите целое число больше 1. ");
                scanner.next(); // this is important!
            }
            countPeople = scanner.nextInt();
        } while (countPeople <= 1);
        System.out.println("\n Значит делим счёт на " + countPeople + " ");
        return countPeople;
    }





    /* Создание списка товаров */
    public static ArrayList<Products> getAddProductsFromUser(){
        String name;
        float price;
        int count;
        String command;
        ArrayList<Products> products = new ArrayList<>();

        System.out.println("\n Конструктор списка товаров. \n " +
                " Для добавления товара введите команду \"Добавить\" \n " +
                " или \"Завершить\" для отмены добавления : ");
        command = scanner.next();

        /* Цикл заполнения списка товаров */
        while (!command.isEmpty()) {
            if (command.equalsIgnoreCase("Добавить")) {
                System.out.println("\n Введите наименование товара : ");
                name = scanner.next();
                System.out.println("\n Введите цену товара : ");
                price = scanner.nextFloat();
                System.out.println("\n Введите количество товара : ");
                count = scanner.nextInt();
                Products product = new Products(name, price, count);
                products.add(product);

                System.out.println("\n Конструктор списка товаров. \n " +
                        " Для добавления товара введите команду \"Добавить\" \n " +
                        " или \"Завершить\" для отмены добавления : ");
                command = scanner.next();

            } else if (command.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("\n Вы ввели \" " + command + " \" ничего не происходит. \n" +
                        " Введите команду \"Добавить\" или \"Завершить\" : ");
                command = scanner.next();
            }
        }
        return products;
    }

}
