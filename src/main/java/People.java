import java.util.Scanner;

public class People {

public static int people;
    public static void people() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" На скольких человек необходимо разделить счёт ? ");
        people = scanner.nextInt();

        while (people <= 1) {
            System.out.println(" Некорректное значение, введите число больше 1. ");
            people = scanner.nextInt();
        }
    }
}
