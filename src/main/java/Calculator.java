import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static ArrayList<String> newItems = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static double bill = 0;
    public static int numberOfPerson;

    public static void addProductsToTheList() {
        double price = 0;

        do {
            System.out.println("Введите наименование товара:");
            String name = scanner.next();
            newItems.add(name);
            System.out.println("Введите стоимость товара:");

            while (true) {
                scanner.nextLine();
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();

                    while (price < 0) {
                        System.out.println("Вы ввели отрицательное число, попробуйте снова. \nВведите стоимость товара:");
                        price = scanner.nextDouble();
                    }
                    break;
                } else {
                    System.out.println("Введенное значение не double. Попробуйте еще раз. \nВведите стоимость товара:");
                    scanner.next();
                }
            }
            bill += price;
            System.out.println("Товар " + name + " стоимостью " + price + " добавлен в список");
            System.out.println("Хотите добавить еще один товар? \n-Да\n-Завершить");

        } while (!scanner.next().equalsIgnoreCase("Завершить"));
    }

    public static double calculate() {
        return(bill/numberOfPerson);
    }

    public static void printItems() {
        System.out.println("Добавленные товары:");
        for (String item: newItems) {
            System.out.println(item);
        }
    }
}
