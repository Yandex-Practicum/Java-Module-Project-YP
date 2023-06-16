import java.util.Scanner;

public class People {
    public static int people;

    public static void people() {
        System.out.println(" На скольких человек необходимо разделить счёт ? ");
        Scanner scanner = new Scanner(System.in);
        boolean character = false;
        while (!character) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                character = true;
            } else {
                System.out.println(" Ошибка, введён текст\n Введите числовое значение");
                scanner.next();
            }
        }
        while (people <= 1) {
            System.out.println(" Некорректное значение, введите число больше 1. ");
            scanner.nextInt();
        }
    }
}



