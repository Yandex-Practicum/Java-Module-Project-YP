import java.util.InputMismatchException;
import java.util.Scanner;

public class PriceChecker {
    public static double check() {
        Scanner scanner = new Scanner(System.in);
        double price = 0.0;

        while (price <= 0.0) {
            try {
                price = scanner.nextDouble();

                if (price <= 0.0) {
                    System.out.println("Цена должна быть больше 0");
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Введите цену товара в формате - рублей.копеек");
            }
        }

        return price;
    }
}
