import java.util.InputMismatchException;
import java.util.Scanner;



class BillSplitter {
    private static double roundToTwoDecimalPlaces(double value) {
        return Math.floor(value * 100) / 100;
    }

    private static String formatPrice(double value, String currency) {
        int remainder10 = (int) value % 10;
        int remainder100 = (int) value % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return String.format("%.2f рубль\n", value);
        } else if (remainder10 >= 2 && remainder10 <= 4 && (remainder100 < 10 || remainder100 >= 20)) {
            return String.format("%.2f рубля\n", value);
        } else {
            return String.format("%.2f рублей\n", value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPerson = 0;
        //Ввод кол-ва персон
        while (true) {
            System.out.print("Укажите количество персон для разделения счета: ");

            try {
                numOfPerson = scanner.nextInt();

                if (numOfPerson == 1) {
                    System.out.println("Ошибка: нельзя разделить счет на одного человека.");
                } else if (numOfPerson < 1) {
                    System.out.println("Ошибка: нельзя указать количество персон меньше одного.");
                } else {
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }

        // Создание калькулятора
        double price = 0.0;
        String name = "";

        while (true) {
            System.out.println("Введите название товара (или 'Завершить' для выхода): ");
            String names = scanner.next();
            if (names.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите цену товара: ");
            double prices = scanner.nextDouble();

            price += prices;
            name += names + "\n";

            System.out.println("Товар успешно добавлен.");
        }
        // Вывод результатов
        System.out.println("Добавленные товары:\n" + name);

        double pricePerPerson = roundToTwoDecimalPlaces(price / numOfPerson);

        System.out.print("Каждый человек должен заплатить: ");
        System.out.println(formatPrice(pricePerPerson, "рубль"));

        scanner.close();
    }
}