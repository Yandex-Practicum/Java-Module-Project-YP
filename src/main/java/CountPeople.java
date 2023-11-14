import java.util.Scanner;

public class CountPeople {
    int allPeople = 0;

    void countPeople() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество человека:");

        while (true) {
            if (scan.hasNextInt()) {
                allPeople = scan.nextInt();
                if (allPeople > 1) {
                    break;
                } else {
                    System.out.println("Ошибка. Введите целое число:");
                }
            } else if (scan.hasNext()) {
                System.out.println("Ошибка. Введите целое число:");
                scan.next();
            }
        }
    }
}
