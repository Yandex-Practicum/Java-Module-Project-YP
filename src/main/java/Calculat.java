import java.util.Scanner;

public class Calculat {
    public static void calculat() {
        Scanner scanner = new Scanner(System.in);
        String product = "", allProducts = " ";
        double account = 0.2f;
        double price = 0.0, allPrice = 0.0;
        int people = 2;
        while (true) {
            System.out.println("Введите название товара.");
            product = scanner.next();
            allProducts += product + "\n";
            System.out.println("Введите стоимость товара.");
            price = scanner.nextDouble();
            allPrice += price;
            System.out.println("Товар успешно добавлен.\nДобавить ещё товар?");
            String input = scanner.next();
            if (input.equalsIgnoreCase("Завершить.") || input.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавленные товары: \n" + allProducts);
                account = allPrice;
                System.out.println("Сумма к оплате:" + account);
                break;
            }
        }

    }
}
