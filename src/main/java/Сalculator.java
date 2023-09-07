import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Сalculator {
    double addProducts() {
        String productsList = "Добавленные товары:\n";
        double totalAmount = 0;
        double productPrice;
        while (true) {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Введите название товара");
            String productName = scanner.nextLine();
            System.out.println("Введите стоимость товара в формате рубли.копейки");
            while(!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод. Введите стоимость товара в формате рубли.копейки");
                scanner.next();
            }
            productPrice = scanner.nextDouble();

            System.out.println(productName + " у вас в корзине!");
            totalAmount = totalAmount + productPrice;
            productsList = productsList.concat(productName).concat("\n");
            System.out.println("Вы хотите добавить что-то еще?");
            scanner.nextLine();
            String command = scanner.next();
            if (command.equalsIgnoreCase("Завершить")) {
                scanner.close();
                break;
            }
        }
        System.out.println(productsList);
        return totalAmount;
    }
}






