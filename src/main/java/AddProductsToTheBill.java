import java.util.Scanner;

public class AddProductsToTheBill {
    public static Scanner scanner = new Scanner(System.in);

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
        Calculator.numberOfPerson = value;
    }
}
