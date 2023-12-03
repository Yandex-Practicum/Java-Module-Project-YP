import java.util.Scanner;

public class Calculator {
    static int persons = 0;
    static String menuSum = "";
   static double priceSum = 0;
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек:");
        while (true) {
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                if (persons < 2) {
                    System.out.println("Введите число больше 1");
                } else {
                    break;
                }
            } else {
                System.out.println("Введите целое число ");
                scanner.next();
            }
        }
        while (true) {
            System.out.println("Введите название товара или введите 'Завершить', что бы выйти");
            scanner.nextLine();
            String menu = scanner.nextLine();
            if (menu.equalsIgnoreCase("Завершить")) {
                System.out.println("Товар успешно добавлен.");
                break;
            }
            menuSum += menu + "\n";
            while (true) {
                System.out.println("Введите цену товара:");
                if (scanner.hasNextDouble()) {
                    double price = scanner.nextDouble();
                    if (price > 0) {
                        priceSum += price;
                        break;
                    } else {
                        System.out.println("Введите число больше 0");
                    }
                } else {
                    System.out.println("Введите число");
                    scanner.next();
                }
            }
        }
    }
}





