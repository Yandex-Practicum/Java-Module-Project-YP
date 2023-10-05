import java.util.Scanner;

public class PeopleNumber {
    static int people;
    public static int count() {
        Scanner scan = new Scanner(System.in);
        int qwest;
        while (true) {
            System.out.println("Введите число гостей:");
            if (scan.hasNextInt()) {
                qwest = Integer.parseInt(scan.nextLine());
                if(qwest>1) {
                    break;
                } else {
                    System.out.println("Вы ввели некорректное число");

                }

            } else {
                System.out.println("Вы ввели не число");
                scan.nextLine();
            }
        }
        return qwest;


    }
}
