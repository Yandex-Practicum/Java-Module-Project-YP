import java.util.Scanner;

public class Product {
    final private String title;
    final private double price;

    Scanner scanner = new Scanner(System.in);

    Product() {
        title = findTitle();
        price = findPrice();

    }

    private String findTitle() {
        System.out.println("Введите название товара: ");
        return scanner.nextLine();
    }

    private double findPrice() {
        System.out.println("Введите его стоимость в формате \"рубли.копейки\": ");
        do {
            String tmpStr = scanner.nextLine().trim();
            if (tmpStr.matches("^[0-9]+\\.[0-9]{2}?$"))
                return Double.parseDouble(tmpStr);
            System.out.println("Неверный ввод. Пожалуйста, введите стоимость в формате \"рубли.копейки\": ");
        } while (true);
    }

    String getProductName() {
        return title;
    }

    double getProductPrice() {
        return price;
    }

}
