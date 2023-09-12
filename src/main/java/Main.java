import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int numberOfGuests;

        while (true) {
            try {
                numberOfGuests = scanner.nextInt();
                if (numberOfGuests > 1) {
                    break;
                } else if (numberOfGuests == 1) {
                    System.out.println("Нет смысла ничего считать и делить. Пожалуйста введите корректное количество гостей.");
                } else {
                    System.out.println("Это некорректное значение для подсчёта. Пожалуйста введите корректное количество гостей.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите целочисленное значение.");
                scanner.next(); // Пропускать неверный ввод
            }
        }
        ExpensesCalculator.calculate(scanner, numberOfGuests);
    }
}