import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public List<Product> calculateBill() {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        String name;
        while (true) {
            System.out.println("Введите наименование блюда");
            name = scanner.next();

            System.out.println("Введите цену ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Введите цену в формате 00.00, пробуем заново");
                scanner.next();
                continue;
            }

            double price = scanner.nextDouble();

            if (Double.compare(0.01, price) > 0) {
                System.out.println("Только 2 знака после запятой, вот так → 00,00 пробуем заново");
                continue;
            }

            products.add(new Product(price, name));

            System.out.println("Завершить подсчет?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить"))
                break;

        }
        return products;
    }


}
