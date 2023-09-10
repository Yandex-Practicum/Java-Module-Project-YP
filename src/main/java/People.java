import java.util.Scanner;

public class People {
    int addNumberOfPeople() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько человек желает разделить счёт?");
        int people = 0;
        while (people <= 1) {
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Ожидается целое число");
                scanner.next();
            }
            people = scanner.nextInt();
            if (people < 1) {
                System.out.println("Вы ввели некорректное значение. Попробуйте ввести еще раз");
            } else if (people == 1) {
                System.out.println("Этот человек и оплачивает :) или введите корректное значение");
            }
        }
        return people;
    }
}
