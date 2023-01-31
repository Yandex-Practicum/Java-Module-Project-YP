import java.util.Scanner;

public class Main {

    private static Calculator calculator;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numberOfPeople = askNumberOfPeople();
        calculator = new Calculator(numberOfPeople);
        askProductAndPrice();
        showResult();
    }

    private static int askNumberOfPeople() {
        System.out.println("Много вас?");
        int numberOfPeople;
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                scanner.nextLine();
                if (numberOfPeople > 1) {
                    return numberOfPeople;
                }
                System.out.println("Введите корректное количество людей (>1)");
            } else {
                System.out.println("Введите число >1");
            }
        }
    }

    public static void askProductAndPrice() {
        while (true) {
            System.out.println("Что кушать изволите?");
            String product = scanner.nextLine();
            System.out.println("Че почем?");
            double price = askPrice();

            calculator.addProduct(product, price);
            System.out.println("Я все запомнил!");
            System.out.println("Еще заказывать будете? Если нет, введите \"завершить\" ");
            String input = scanner.nextLine();
            if ("завершить".equalsIgnoreCase(input)) {
                break;
            }
        }
    }

    private static double askPrice() {
        while (true) {
            double price;
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    System.out.println("Бесплатный сыр только в мышеловке! Некорректная цена");
                } else {
                    return price;
                }
            } else {
                scanner.nextLine();
                System.out.println("Введите цену в формате рубли.копейки");
            }
        }
    }

    private static void showResult() {
        System.out.println("Добавленные товары:");
        System.out.println(calculator.getProducts());
        double personalBill = calculator.getPersonalBill();
        double first = Math.floor(personalBill / 10) % 10;
        double second = Math.floor(personalBill) % 10;
        String rubName;
        if (second == 1 && first != 1) {
            rubName = "рубль";
        } else if (second >= 2 && second <= 4 && first != 1) {
            rubName = "рубля";
        } else {
            rubName = "рублей";
        }
        System.out.println(String.format("С носа : %.2f %s", personalBill, rubName));
    }
}