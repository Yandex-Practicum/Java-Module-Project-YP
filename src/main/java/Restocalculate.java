import java.util.ArrayList;
import java.util.Scanner;

public class Restocalculate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = promptForNumberOfPeople(scanner);

        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            System.out.print("Введите название товара (или 'завершить' для прекращения добавления товаров): ");
            String productName = scanner.nextLine().toLowerCase();

            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }

            double productPrice = promptForPrice(scanner);
            if (productPrice <= 0.0) {
                System.out.println("Введите корректную цену.");
                continue;
            }

            Product product = new Product(productName, productPrice);
            products.add(product);
        }

        if (products.isEmpty() || numberOfPeople < 1) {
            System.out.println("Недостаточно данных. Количество людей должно быть больше 1, и товары необходимы.");
            return;
        }

        System.out.println("\nСписок товаров и цен:");
        products.forEach(product -> System.out.println(product));

        double totalCost = products.stream().mapToDouble(Product::getPrice).sum();
        double averageCostPerPerson = totalCost / numberOfPeople;

        AmountFormatter formatter = new AmountFormatter();
        System.out.println("\nОбщая сумма цен товаров: " + formatter.format(totalCost));
        if (numberOfPeople > 1) {
            System.out.println("Каждый человек должен заплатить: " + formatter.format(averageCostPerPerson));
        } else {
            System.out.println("Счет делить не нужно, так как всего 1 человек.");
        }
        System.out.println("Количество человек: " + numberOfPeople);

        scanner.close();
    }

    private static int promptForNumberOfPeople(Scanner scanner) {
        int numberOfPeople;
        do {
            System.out.print("Введите количество человек (больше 1): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите корректное число.");
                scanner.next();
            }
            numberOfPeople = scanner.nextInt();
            scanner.nextLine();
        } while (numberOfPeople < 1);
        return numberOfPeople;
    }

    private static double promptForPrice(Scanner scanner) {
        double price = 0.0;
        do {
            System.out.print("Введите цену товара в формате рубли.копейки (должна быть положительной): ");
            try {
                String priceInput = scanner.nextLine().replaceAll("[^\\d.]", "");
                price = Double.parseDouble(priceInput);
                if (price <= 0.0) {
                    System.out.println("Цена должна быть положительной и больше 0. Пожалуйста, введите корректную цену.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректную цену.");
            }
        } while (price <= 0.0);
        return price;
    }
}

class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + ": " + AmountFormatter.format(price);
    }
}

class AmountFormatter {
    public static String format(double amount) {
        int lastDigit = (int) amount % 10;
        int lastTwoDigits = (int) amount % 100;

        String format = "%.2f рублей";

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return String.format(format, amount);
        } else {
            switch (lastDigit) {
                case 1:
                    format = "%.2f рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    format = "%.2f рубля";
                    break;
            }
            return String.format(format, amount);
        }
    }
}












