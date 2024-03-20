

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счет?");
        while (!scanner.hasNextInt()) {

            System.out.println("Ошибка. Введите число.");
            scanner.next();
        }
        int namber = scanner.nextInt();
        while (namber <= 0 ) {
            System.out.println("Ошибка. Попробуйте ввести новое значение, больше 1.");
            namber = scanner.nextInt();
        }
        if (namber == 1) {
            System.out.println("В этом случае нет смысла в вычислениях. Попробуйте ввести новое значение.");
            namber = scanner.nextInt();
        }
        class RubleUtil {

            public static String formatRubles(double amount) {
                String result;
                double rubles = amount % 10;

                if (rubles == 1 && amount != 11) {
                    result = "рубль";
                } else if (rubles >= 2 && rubles <= 4 && !(amount >= 12 && amount <= 14)) {
                    result = "рубля";
                } else {
                    result = "рублей";
                }

                return result;
            }
        }
        NamberPerson nPerson = new NamberPerson();
        nPerson.setPerson(namber);
        nPerson.isPerson();
        Calculator calculator = new Calculator();
        calculator.Xerson();


        System.out.println("Добавленные товары:");

        System.out.println("Общая сумма: " + String.format("%.2f", calculator.getTotalCoast()) + " " + RubleUtil.formatRubles(calculator.getTotalCoast()) );

        double individualPayment = calculator.getTotalCoast() / nPerson.getPerson();
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", individualPayment) + " " + RubleUtil.formatRubles(individualPayment));
            }

}
//  Работу сдал Максим Грузинцев
