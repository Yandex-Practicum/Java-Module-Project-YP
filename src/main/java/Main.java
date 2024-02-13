
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счёт?");
        int numPeople = readInt(scanner);

        while (numPeople <= 1) {
            System.out.println("Некорректное значение для подсчёта, количество людей должно быть больше 1.");
            numPeople = readInt(scanner);
        }

        Calculator calculator = new Calculator();
        String input;

        do {
            System.out.println("Введите название товара:");
            String itemName = scanner.next();

            System.out.println("Введите стоимость товара в формате рубли.копейки:");
            double itemPrice = readDouble(scanner);

            calculator.addItem(itemName, itemPrice);
            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить ещё один товар? (Введите 'Завершить', чтобы закончить добавление):");
            input = scanner.next();
        } while (!input.equalsIgnoreCase("Завершить"));

        System.out.println("Добавленные товары:");
        System.out.println(calculator.getItems());
        double perPerson = calculator.getTotal() / numPeople;
        System.out.println(formatRubles(perPerson));
    }

    public static String formatRubles(double sum) {
        int integerPart = (int) sum;
        int remainder = integerPart % 10;
        String rubleSuffix;
        if (integerPart == 1) {
            rubleSuffix = "рубль";
        } else if (remainder > 1 && remainder < 5) {
            rubleSuffix = "рубля";
        } else {
            rubleSuffix = "рублей";
        }
        return String.format("Каждый человек должен заплатить по %.2f %s", sum, rubleSuffix);
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double readDouble (Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число в формате рубли.копейки:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
