import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGuests = 0;
        while (true) {
            System.out.println("Пожалуйста, введите количество гостей:");
            System.out.println("Please, enter the number of guests:");
            while (true){
                try {
                    numberOfGuests = scanner.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("Пожалуйста введите число");
                    System.out.println("Please, enter a number");
                   scanner.next();
                   continue;
                }
            }

            if (numberOfGuests < 2) {
                System.out.println("Пожалуйста, введите корректное значение гостей или платите сами.");
                System.out.println("Please, enter a correct number of guests or pay yourself.");
            } else {
                System.out.println("Число гостей " + numberOfGuests);
                System.out.println("Number of guests " + numberOfGuests);
                break;
            }
        }
        Calculator.calculate(numberOfGuests);
    }
}