import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счет?");
        int howMany;

        while (true) {
            if (scanner.hasNextInt()) {
                howMany = scanner.nextInt();
                if (howMany > 1) {
                    break;
                } else {
                    System.out.println("Ошибка! Введите число больше чем 1:");
                }
            } else {
                scanner.nextLine();
                System.out.println("Извините, но это явно не число. Повторите ввод:");
            }
        }
        Calculator.calculate(howMany);
        scanner.close();
    }
}


