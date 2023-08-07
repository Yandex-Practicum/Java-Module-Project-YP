import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static double totalSum = 0;
    public static String checkList = "";

    static void calculate(int numberOfGuests) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String item = "";
            while (true) {
                System.out.println("Пожалуйста, введите товар:");
                System.out.println("Please, enter item name:");
                try {
                    item = scanner.next();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод");
                    System.out.println("Incorrect enter");
                    scanner.next();
                    continue;
                }
            }


            double cost = 0;
            while (true) {
                System.out.println("Пожалуйста, введите его стоимость:");
                System.out.println("Please enter it's cost:");
                try {
                    cost = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод");
                    System.out.println("Incorrect enter");
                    scanner.next();
                    continue;
                }
            }

            totalSum += cost;
            String itemString = item + " " + String.format("%.2f", cost);
            System.out.println(itemString);
            checkList += itemString + '\n';
            System.out.println("Добавленные товары:");
            System.out.println("Added items:");
            System.out.println(checkList);
            System.out.println("Вы хотите добавить ещё товар? Введите любой символ, чтобы перейти к вводу нового товара. Введите \"завершить\" чтобы закончить добавление товаров в список:");
            System.out.println("Continue? Enter any symbol if \"yes\". Enter \"завершить\" to end:");
            String choice = scanner.next();
            if (Objects.equals(choice.toLowerCase(Locale.ROOT), "завершить")) {
                double endsWith = Math.floor(totalSum / numberOfGuests) % 10;
                if (endsWith == 1) {
                    System.out.println("Вы должны заплатить " + String.format("%.2f", totalSum / numberOfGuests) + " рубль");
                    System.out.println("You must pay " + String.format("%.2f", totalSum / numberOfGuests) + " rubles");

                } else if (endsWith == 2 || endsWith == 3 || endsWith == 4) {
                    System.out.println("Вы должны заплатить " + String.format("%.2f", totalSum / numberOfGuests) + " рубля");
                    System.out.println("You must pay " + String.format("%.2f", totalSum / numberOfGuests) + " rubles");
                } else {
                    System.out.println("Вы должны заплатить " + String.format("%.2f", totalSum / numberOfGuests) + " рублей");
                    System.out.println("Ypu must pay " + String.format("%.2f", totalSum / numberOfGuests) + " rubles");
                }
                break;
            }
        }
    }
}
