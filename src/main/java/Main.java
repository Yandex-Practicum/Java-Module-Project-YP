

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPersons = 0;

        do {
            System.out.println("Введите количество персон:");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка, введите пожалуста число.");
                scanner.next();
            }
            numberOfPersons = scanner.nextInt();

            if (numberOfPersons <= 0) {
                System.out.println("Введите, введите пожалуйста число больше 0");
            } else if (numberOfPersons == 1) {
                System.out.println("Нет смысла в дальнейших вычислениях.");
            }

        } while (numberOfPersons <= 0 || numberOfPersons == 1);

        Calculator calculator = new Calculator();
        calculator.calculateTotalCost();

        RubleUtil rubleUtil = new RubleUtil();
        String rublesSuffix = RubleUtil.getRublesFormattedString(calculator.getTotalCoast());

        NamberPerson nPerson = new NamberPerson();
        nPerson.setPerson(numberOfPersons);

        double individualPayment = calculator.getTotalCoast() / numberOfPersons;
        String individualPaymentRubles = rubleUtil.getRublesFormattedString(individualPayment);

        System.out.println("Общая сумма: " + String.format("%.2f", calculator.getTotalCoast()) + " " + rublesSuffix);
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", individualPayment) + " " + individualPaymentRubles);
    }
}//  Работу сдал Максим Грузинцев
