import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator insaf = new Calculator();


        System.out.println("Добро пожаловать в приложение \"Раздели счет\"");
        System.out.println("На сколько человек необходимо разделить счет?");

        int people;
        double splitSum;

        while (true) {

            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people > 1) {
                    insaf.Calculate();
                    splitSum = insaf.totalCost / people;
                    int splitSumInt = (int) splitSum;
                    int lastDigit = splitSumInt % 10;
                    int lastTwoDigits = splitSumInt % 100;
                    if (lastTwoDigits >= 11 && lastTwoDigits <= 20) {
                        System.out.println("Сумма на каждого человека: " + splitSum + " рублей");
                    } else if (lastDigit == 1) {
                        System.out.println("Сумма на каждого человека: " + splitSum + " рубль");
                    } else if (lastDigit >= 2 && lastDigit <= 4) {
                        System.out.println("Сумма на каждого человека: " + splitSum + " рубля");
                    } else {
                        System.out.println("Сумма на каждого человека: " + splitSum + " рублей");
                    }
                    break;

                } else if (people == 1) {
                    System.out.println("Введено ошибочное значение, пожалуйста повторите попытку");// Смысла делить счет нет одному человеку

                } else
                    System.out.println("Введено ошибочное значение, пожалуйста повторите попытку");// Смысла делить счет нет, если никого нет

            } else {
                System.out.println("Введено ошибочное значение, пожалуйста повторите попытку");
            }
            scanner.nextLine();


        }
    }
}