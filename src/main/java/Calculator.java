import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
     static Scanner scanner = new Scanner(System.in);
     static double totalPrice = 0;

    static String name;
    static String command;

    static double inputPrice;

    static double price;
    static ArrayList<Item> itemList = new ArrayList<>();

    static void addItem() {

        do {
            System.out.println("Введите позицию из чека: ");
            name = scanner.nextLine();
            while (true) {
                System.out.println("Введите стоимость в формате РУБЛИ,КОПЕЙКИ: ");
                if (scanner.hasNextDouble()) {
                    inputPrice = scanner.nextDouble();
                    scanner.nextLine();
                }
                if (inputPrice >= 0) {
                    break;
                }
                else {
                    System.out.println("Ошибка ввода. Введите корректную стоимость в формате РУБЛИ,КОПЕЙКИ: ");
                    scanner.nextLine();
                }
            }
            price = Formatter.round(inputPrice);
            itemList.add(new Item(name, price));
            totalPrice = totalPrice + price;
            System.out.println("Вы добавили: " + name + " за " + price + " " + Formatter.getRubleAddition(price) + "\nОбщая сумма: " + Formatter.round(totalPrice) + " " + Formatter.getRubleAddition(totalPrice));
            System.out.println("Добавить еще? Введите любой символ, чтобы продолжить. Чтобы завершить процесс добавления, наберите команду \"Завершить\"");
            command = scanner.nextLine();
        }
        while (!command.equalsIgnoreCase("Завершить"));
        }


         static void total() {
            System.out.println("Все позиции чека: ");
            for (Item item : itemList) {
            System.out.println(item.getName() + " за " + item.getPrice() + " " + Formatter.getRubleAddition(item.getPrice()));
            }
            System.out.println("Итоговая общая сумма: " + Formatter.round(totalPrice) + " " + Formatter.getRubleAddition(totalPrice));
             System.out.println("Количество персон: " + PersonInput.persons);
            System.out.println("Итого с каждого по: " + Formatter.round(totalPrice/PersonInput.persons) +" "+ Formatter.getRubleAddition(totalPrice/PersonInput.persons));

        }


    }

