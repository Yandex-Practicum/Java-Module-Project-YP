
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople;
        String productList = "";
        double totalSum = 0.0;

        while (true) {
            System.out.print("Введите количество гостей: ");
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople == 1) {
                System.out.println("Нет смысла считать и делить на одного человека!");
            } else if (numberOfPeople < 1) {
                System.out.println("Некорректное количество гостей!");
            } else {
                break;
            }
        }

        Calculator calculator = new Calculator(numberOfPeople);
        System.out.println("Список добавленных товаров: " + productList);
        System.out.println("Общая сумма всех товаров: " + totalSum + " руб.");

        Formatter formatter = new Formatter(calculator.getAmountPerPerson());
        System.out.println("Сумма на каждого человека: " + formatter.getResult());
    }

    public static class Calculator {
        private int people;
        private double amountPerPerson;

        public Calculator(int people) {
            Scanner scanner = new Scanner(System.in);
            StringBuilder productList = new StringBuilder();

            double totalSum = 0.0;
            while (true) {
                System.out.print("Введите название товара (или 'Завершить' для выхода): ");
                String productName = scanner.next().trim();
                if (productName.equalsIgnoreCase("Завершить")) {
                    break;
                }
                System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
                double productPrice = scanner.nextDouble();
                scanner.nextLine(); // Читаем символ новой строки после чтения значения стоимости

                totalSum += productPrice;
                productList.append(productName).append(", ");

                System.out.println("Товар успешно добавлен.");
            }
            amountPerPerson = totalSum / people;
            System.out.println("Список добавленных товаров: " + productList);
            System.out.println("Общая сумма всех товаров: " + totalSum + " руб.");
        }

        public double getAmountPerPerson() {
            return amountPerPerson;
        }
    }

    public static class Formatter {
        private double amount;
        private final String result;

        public Formatter(double amount) {
            DecimalFormat formatter = new DecimalFormat("0.00");
            String formattedAmount = formatter.format(amount);
            String currencySuffix;
            int wholePart = (int) amount;
            int remainderOf10 = wholePart % 10;
            int remainderOf100 = wholePart % 100;
            if (remainderOf10 == 1 && remainderOf100 != 11) {
                currencySuffix = " рубль.";
            } else if (remainderOf10 >= 2 && remainderOf10 <= 4 && (remainderOf100 < 10 || remainderOf100 >= 20)) {
                currencySuffix = " рубля.";
            } else {
                currencySuffix = " рублей.";
            }
            result = formattedAmount + currencySuffix;
        }

        public String getResult() {
            return result;
        }
    }
}
