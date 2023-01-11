import java.util.Scanner;

public class Counter {
    public static int count() {
        System.out.println("Сколько человек?");
        int persons = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number < 2) {
                    System.out.println("Разделить можно только на несколько человек.");
                } else {
                    persons = number; //количество человек
                    break;
                }
            } else {
                System.out.println("Введите целое положительное число.");
            }
        }
        return persons;
    }
}
