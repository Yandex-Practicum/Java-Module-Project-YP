import java.math.RoundingMode;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> itemsList = new ArrayList<>();
        double allItems = 0;

        while (true) {
            askWhatToDo();
            String command = scanner.next();

            if (command.equalsIgnoreCase("1")) {
                while (true) {
                    System.out.println("Введите название товара:");
                    String itemName = scanner.next();
                    itemsList.add(itemName);

                    System.out.println("Введите стоимость товара:");
                    double itemPrice;
                    while (true) {
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Ошибка: введено не число. Попробуйте еще раз:");
                            scanner.next();
                        }
                        itemPrice = scanner.nextDouble();
                        if (itemPrice <= 0) {
                            System.out.println("Ошибка: число отрицательное, или ноль. Попробуйте еще раз:");
                        } else {
                            break;
                        }
                    }

                    allItems += itemPrice;
                    System.out.println("Товар внесен в список!");
                    System.out.println("Хотите добавить еще один товар? \n-Да\n-Нет");
                    String commandAddMoreItem = scanner.next();
                    if (commandAddMoreItem.equalsIgnoreCase("Да")) {
                        continue;
                    } else {
                        break;
                    }
                }
            } else if (command.equalsIgnoreCase("2")) {
                System.out.println("Добавленные товары: ");
                printItemsList(itemsList);
                System.out.println("Сумма вашего заказа: " + allItems);
                System.out.println("Если поделить счёт на всех, то получится: " + formatCurrency(calculate(allItems)));
            } else if (command.equalsIgnoreCase("3")) {
                System.out.println("Ваши товары:");
                printItemsList(itemsList);
                System.out.println("Сумма вашего заказа: " + allItems);
            } else if (command.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Извините, такой команды не существует.");
            }
        }
    }

    public static void printItemsList(ArrayList<String> itemList) {
        for (String item : itemList) {
            System.out.println(item);
        }
    }

    public static double calculate(double totalBill) {
        System.out.println("Введите количество людей для разделения счета:");
        Scanner scanner = new Scanner(System.in);
        int givenNumberOfPeople = scanner.nextInt();

        while (givenNumberOfPeople < 1) {
            System.out.println("Введенное число неверно. Попробуйте еще раз");
            givenNumberOfPeople = scanner.nextInt();
        }
        if (givenNumberOfPeople > 1) {
            BigDecimal totalAmount = BigDecimal.valueOf(totalBill);
            BigDecimal numberOfPeople = BigDecimal.valueOf(givenNumberOfPeople);
            BigDecimal share = totalAmount.divide(numberOfPeople, 2, RoundingMode.HALF_UP);
            return share.doubleValue();
        } else {
            System.out.println("Количество человек: 1. Счет не делится =(");
            return totalBill;
        }
    }

    public static void askWhatToDo () {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести наименование товара");
        System.out.println("2 - Разделить счёт");
        System.out.println("3 - Принести счёт");
        System.out.println("'Завершить' - Выход");
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