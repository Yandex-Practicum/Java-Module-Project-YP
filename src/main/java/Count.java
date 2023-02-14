import java.util.Scanner;

public class Count {

    static int count() {
        int number ;
        int persons;
        Scanner sc = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счет?");
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number == 1) {
                    System.out.println("Вы один, вам за все и платить!");
                } else if (number < 1) {
                    System.out.println("Введите целое положительное число.");
                } else {
                    persons = number;
                    break;
                }
            }
                else {
                    System.out.println("Введите число.");
                    sc.nextLine();
                }
        }
        return persons;
    }
}