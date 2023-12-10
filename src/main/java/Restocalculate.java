import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

            BigDecimal productPrice = promptForPrice(scanner);
            if (productPrice == null) {
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
        products.forEach(System.out::println);

        BigDecimal totalCost = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal averageCostPerPerson = totalCost.divide(BigDecimal.valueOf(numberOfPeople), 2, RoundingMode.HALF_UP);

        System.out.println("\nОбщая сумма цен товаров: " + formatAmount(totalCost));
        if (numberOfPeople > 1) {
            System.out.println("Каждый человек должен заплатить: " + formatAmount(averageCostPerPerson));
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

    private static BigDecimal promptForPrice(Scanner scanner) {
        BigDecimal price = null;
        do {
            System.out.print("Введите цену товара в формате рубли.копейки (должна быть положительной): ");
            try {
                String priceInput = scanner.nextLine().replaceAll("[^\\d.-]", "");
                if (priceInput.startsWith("-")) {
                    System.out.println("Цена должна быть положительной. Пожалуйста, введите корректную цену.");
                    continue;
                }
                price = new BigDecimal(priceInput).setScale(2, RoundingMode.HALF_UP);
                if (price.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Цена должна быть положительной и больше 0. Пожалуйста, введите корректную цену.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректную цену.");
            }
        } while (price == null || price.compareTo(BigDecimal.ZERO) <= 0);
        return price;
    }

    private static String formatAmount(BigDecimal amount) {
        int lastDigit = amount.intValue() % 10;
        int lastTwoDigits = amount.intValue() % 100;

        DecimalFormat decimalFormat;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            decimalFormat = new DecimalFormat("#,##0.00 рублей");
        } else {
            switch (lastDigit) {
                case 1 -> decimalFormat = new DecimalFormat("#,##0.00 рубль");
                case 2, 3, 4 -> decimalFormat = new DecimalFormat("#,##0.00 рубля");
                default -> decimalFormat = new DecimalFormat("#,##0.00 рублей");
            }
        }
        return decimalFormat.format(amount);
    }
}

class Product {
    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + formatAmount(price);
    }

    private static String formatAmount(BigDecimal amount) {
        int lastDigit = amount.intValue() % 10;
        int lastTwoDigits = amount.intValue() % 100;

        DecimalFormat decimalFormat;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            decimalFormat = new DecimalFormat("#,##0.00 рублей");
        } else {
            switch (lastDigit) {
                case 1 -> decimalFormat = new DecimalFormat("#,##0.00 рубль");
                case 2, 3, 4 -> decimalFormat = new DecimalFormat("#,##0.00 рубля");
                default -> decimalFormat = new DecimalFormat("#,##0.00 рублей");
            }
        }
        return decimalFormat.format(amount);
    }
}
