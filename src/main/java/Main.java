import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем количество людей для разделения счета
        int numberOfPeople = getNumberOfPeople(scanner);

        // Создаем объект калькулятора
        BillCalculator calculator = new BillCalculator(numberOfPeople);

        // Ввод товаров
        while (true) {
            System.out.print("Введите название товара (или 'Завершить' для окончания ввода): ");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("Завершить")) {
                break;
            }

            double itemPrice = getItemPrice(scanner);

            calculator.addItem(itemName, itemPrice);
        }

        // Вывод результатов
        calculator.displayBill();
    }

    private static int getNumberOfPeople(Scanner scanner) {
        int numberOfPeople;
        do {
            System.out.print("Введите количество людей для разделения счета: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: Введите число больше 1.");
                scanner.next(); // Пропускаем некорректный ввод
            }
            numberOfPeople = scanner.nextInt();

            if (numberOfPeople <= 0) {
                System.out.println("Ошибка: Некорректное значение. Введите число больше 0.");
            }
        } while (numberOfPeople <= 0);
        return numberOfPeople;
    }

    private static double getItemPrice(Scanner scanner) {
        double itemPrice;
        do {
            System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка: Введите корректную стоимость.");
                scanner.next(); // Пропускаем некорректный ввод
            }
            itemPrice = scanner.nextDouble();
            if (itemPrice < 0) {
                System.out.println("Ошибка: Стоимость не может быть отрицательной.");
            }
        } while (itemPrice < 0);
        return itemPrice;
    }
}

class BillCalculator {
    private final int numberOfPeople;
    private final List<String> items = new ArrayList<>();
    private final List<Double> prices = new ArrayList<>();

    public BillCalculator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void addItem(String itemName, double itemPrice) {
        items.add(itemName);
        prices.add(itemPrice);
        System.out.println("Товар '" + itemName + "' с ценой " + formatPrice(itemPrice) + " успешно добавлен.");
    }

    public void displayBill() {
        System.out.println("\nДобавленные товары:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + ": " + formatPrice(prices.get(i)));
        }

        double totalBill = calculateTotalBill();
        double sharePerPerson = totalBill / numberOfPeople;

        System.out.println("\nСумма, которую каждый должен заплатить:");
        for (int i = 1; i <= numberOfPeople; i++) {
            System.out.println("Человек " + i + ": " + formatPrice(sharePerPerson));
        }
    }

    private double calculateTotalBill() {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    private String formatPrice(double price) {
        int rubles = (int) price;
        int kopecks = (int) ((price - rubles) * 100);
        int rublesLastDigit = rubles % 10;

        if (rubles >= 11 && rubles <= 19) {
            return rubles + " рублей " + kopecks + " копеек";
        } else {
            return switch (rublesLastDigit) {
                case 1 -> rubles + " рубль " + kopecks + " копеек";
                case 2, 3, 4 -> rubles + " рубля " + kopecks + " копеек";
                default -> rubles + " рублей " + kopecks + " копеек";
            };
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}