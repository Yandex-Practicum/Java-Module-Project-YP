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

        PriceFormatter formatter = new PriceFormatter();
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
            System.out.print("Введите количество человек (больше 0): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите корректное число.");
                scanner.next();
            }
            numberOfPeople = scanner.nextInt();
            scanner.nextLine();
            if (numberOfPeople <= 0) {
                System.out.println("Введите положительное число больше 0.");
            }
        } while (numberOfPeople <= 0);
        return numberOfPeople;

    }

    private static double promptForPrice(Scanner scanner) {
        double price = 0.0;
        do {
            System.out.print("Введите цену товара в формате рубли.копейки (должна быть положительной): ");
            try {
                String priceInput = scanner.nextLine().trim();
                if (priceInput.startsWith("-") || priceInput.contains("-") || priceInput.equals("") || priceInput.equals(".")) {
                    System.out.println("Цена должна быть положительной. Пожалуйста, введите корректную цену.");
                    continue;
                }
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














