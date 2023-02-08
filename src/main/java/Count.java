import java.util.Scanner;

public class Count {
    public static int count() {

        int persons;
        int number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек необходимо разделить счет?");
            while (true) {
                if (sc.hasNextInt()) {
                     number = sc.nextInt();
                    break;
                }
                else {
                    sc.next();
                    System.out.println("Некорректный ввод, попробуйте еще раз");
                }
            }
            if (sc.hasNextInt()) {
                if (number < 1) {
                    System.out.println("Некорректный ввод, попробуйте еще раз");
                } else if (number == 1) {
                    System.out.println("Вы один, вам за все и платить!");
                } else {
                    persons = number;
                    break;
                }
            }
        }
        return persons;
    }


}

