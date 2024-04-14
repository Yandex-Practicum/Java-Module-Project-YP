import java.util.Scanner;

public class PersonInput {
   static  int persons;

     static void personRequest() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество персон: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода. Введите число.");
                scanner.next();
            }
            persons = scanner.nextInt();
            if (persons >= 2) {
                break;
            } else {
                System.out.println("Некорректное значение, повторите ввод");
            }
        }
        System.out.println("Количество персон: " + persons);
    }
}
