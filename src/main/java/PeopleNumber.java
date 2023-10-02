import java.util.Scanner;

public class PeopleNumber {
    static int people = 0;
    public static int count() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число гостей:");
        if(scan.hasNextInt()) {
            people = scan.nextInt();
            while (people <= 1) {
                System.out.println("Некорректное количество гостей. Введите число еще раз:");
                people = scan.nextInt();
            }
        } else {
            System.out.println("Вы ввели не число");
            count();
        }

        return people;

    }
}
