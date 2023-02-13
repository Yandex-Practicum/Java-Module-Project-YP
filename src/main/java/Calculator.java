import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    String sumNameProduct = "";
    double sumPriceProduct;

    public void calculate() {
        while (true) {
            System.out.println("Введите название товара:");
            product.nameProduct = scanner.next();
            if (product.nameProduct.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавление товара завершено.");
                break;
            }
            System.out.println("Введите цену блюда:");
            while (!scanner.hasNextDouble()){
                scanner.next();
                System.out.println("Введите число!");
            }
            product.priceProduct = scanner.nextDouble();

            sumPriceProduct = sumPriceProduct + product.priceProduct;
            sumNameProduct = sumNameProduct + product.nameProduct + "\n";
        }
    }
}
