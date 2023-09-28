
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = 0;
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            try {
                people = scanner.nextInt();
                if (people > 1) {
                    break;
                }
                else  {
                    System.out.println("Введите число от 2 и более.");
                }
            } catch (Exception a) {
                System.out.println("Введите корректное число.");
                scanner.nextLine();
            }
        }
        Calculator calculator = new Calculator();
        calculator.newProduct(people);
    }
}
