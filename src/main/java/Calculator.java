import java.util.Scanner;

public class Calculator {
    double sum = 0;
    String listProduct = "Добавленные товары:\n";

    public void sumProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        while (true) {
            System.out.println("Введите название товара");// ваш код начнется здесь

            product.name = scanner.next();
            listProduct = listProduct + product.name + "\n";

            System.out.println("Введите цену товара в формате рубли.копейки");// ваш код начнется здесь

            product.price = scanner.nextDouble();
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