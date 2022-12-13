import java.util.Scanner;

public class Calculator {
    double sum = 0;
    String listProduct = "Добавленные товары:\n";

    public void sumProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        while (true) {
            System.out.println("Введите название товара");

            product.name = scanner.next();
            listProduct = listProduct + product.name + "\n";
            boolean isRightPrice = false;
            while (!isRightPrice) {
                System.out.println("Введите цену товара в формате рубли.копейки");

                if (scanner.hasNextDouble()) {
                    product.price = scanner.nextDouble();

                    if (product.price < 0) {
                        System.out.println("Цена не может быть отрицательной");
                    } else {
                        isRightPrice = true;
                    }
                } else {
                    System.out.println("Вы ввели не число!");
                    scanner.next();
                }
            }
            sum = sum + product.price;

            System.out.println("Товар добавлен");
            System.out.println("Хотите ли вы добавить еще товар?");
            System.out.println("Для завершения добавления товаров напишите Завершить");

            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }
}