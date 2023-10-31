import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount;
        while (true) {
            System.out.println("Введите количество человек (больше одного)");
            if (scanner.hasNextInt()) {
                peopleCount = scanner.nextInt();
                if (peopleCount <= 1) {
                    System.out.println("Количество человек должно быть больше одного");
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод. Введите целое число.");
                scanner.next();

            }
        }
        Calculator calculator = new Calculator(peopleCount);

        while (true) {
            System.out.println("Введите название товара:");
            String name = scanner.next();

            double price;
            while (true) {
                System.out.println("Введите цену товара:");
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price <= 0) {
                        System.out.println("Цена должна быть положительным числом");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Некорректный ввод. Введите число.");
                    scanner.next();
                }
            }

            Product product = new Product(name, price);
            calculator.addProduct(product);

            System.out.println("Добавить еще товар? (\"Завершить\" для выхода)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        System.out.println("\nДобавленные товары");
        for (Product product : calculator.getProducts()) {
            System.out.println(product.name + " - " + product.price + " руб. ");
        }

        double perPerson = calculator.getDividedCheck();
        String formatted = String.format("%.2f", perPerson);
        System.out.println("\nИтого: " + formatted + " " + Formatter.formatRuble(perPerson) + " с каждого");
    }
}