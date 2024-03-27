import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> newItems = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static double bill = 0;
    public static int numberOfPerson;

    public static void main(String[] args) {
        askTheBill();
        addProductsToTheList();
        printItems();
        System.out.println("Каждый должен заплатить по " + formatCurrency(calculate()));
    }

    public static void askTheBill() {
        System.out.println("На сколько человек разделить счет?");

        while (!scanner.hasNextInt()) {
            System.out.println("Некорректное значение. Попробуйте ввести еще раз");
            scanner.next();
        }
        int value = scanner.nextInt();

        while (value < 0) {
            System.out.println("Некорректное значение. Попробуйте ввести еще раз");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректное значение. Попробуйте ввести число.");
                scanner.next();
            }
            value = scanner.nextInt();
        }
        numberOfPerson = value;
    }

    public static void addProductsToTheList() {
        double price = 0;

        do {
            System.out.println("Введите наименование товара:");
            String name = scanner.next();
            newItems.add(name);
            System.out.println("Введите стоимость товара:");

            while (true) {
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

    public static String formatCurrency(double amount) {
        int lastDigit = (int) amount % 10;
        String currency;

        if (lastDigit == 1) {
            currency = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            currency = "рубля";
        } else {
            currency = "рублей";
        }
        return String.format("%.2f %s", amount, currency);
    }
}