import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        System.out.println("На сколько человек разделить счет?");
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        while (true) {
            int count = 0;
            try {
                count = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Введите количество людей");
                scanner.nextLine();
                continue;
            }

            if (count == 1) {
                System.out.println("Для одной персоны не нужно делить счет");
                continue;
            }
            if (count < 1) {
                System.out.println("Некорректное число посетителей");
                continue;
            }
            // если попали сюда - было больше одного
            calc.persons = count;
            calc.calculate();
            break;
        }
    }
}
