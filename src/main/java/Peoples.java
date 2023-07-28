import java.util.InputMismatchException;
import java.util.Scanner;

public class Peoples {

    public static int check () {
        Scanner scanner = new Scanner(System.in);

        int peoples = 1;

        while (peoples <= 1) {
            System.out.println("Введите количество людей:");

            try {
                peoples = scanner.nextInt();

                if (peoples > 1) {
                    System.out.println("Спасибо!");
                } else {
                    System.out.println("Количество людей должно быть больше одного");
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Введите количество людей цифрой");
            }
        }
        return peoples;
    }
}
