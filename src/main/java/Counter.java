import java.util.Scanner;
public class Counter {
    public static int count () {
        System.out.println("Привет Мир");
        System.out.println("На скольких человек необходимо разделить счет?");
        int persons=0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                //System.out.println(number);
                if (number < 2) {
                    System.out.println("Счет можно разделить только на несколько человек.");
                } else {
                    persons=number;
                    break;
                }
            } else {
                System.out.println("Введите целое положительное число.");
            }
        }
    return persons;
    }
}
