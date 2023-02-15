import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    String sumNameProduct = "";
    double sumPriceProduct;

    public void calculate() {
        while (true) {
            System.out.println("Введите название блюда:");
            product.nameProduct = scanner.next();
            if (product.nameProduct.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавление блюда завершено.");
                break;
            }
            System.out.println("Введите цену блюда:");
            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Введите число!");
            }
            while (true) {
                product.priceProduct = scanner.nextDouble();
                if (product.priceProduct > 1) {
                    break;
                } else if (product.priceProduct < 1) {
                    System.out.println("Цена блюда не может быть отрицательной");
                } else {
                    System.out.println("Некорректные данные");
                }
            }sumPriceProduct = sumPriceProduct + product.priceProduct;
            sumNameProduct = sumNameProduct + product.nameProduct + "\n";
        }
    }
}