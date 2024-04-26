import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int numberPersons;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введи количество гостей, на которых нужно разделить счёт");

            if (scanner.hasNextInt()) {
                numberPersons = scanner.nextInt();
                scanner.nextLine();
                if (numberPersons <= 1) {
                    System.out.println("Ошибка! Количество гостей должно быть больше 1.");
                } else {
                    Calculator.count();
                    break;
                }

            } else {
                System.out.println("Ошибка! Некорректное значение");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}