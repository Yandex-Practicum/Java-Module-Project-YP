import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На сколько человек необходимо рзаделить счет?");
            int userInput = scanner.nextInt();
            if (userInput > 1) {
                calculator.account(userInput);
                break;
            } else {
                System.out.println("Количество человек должно быть больше 1. Пожалуйста, введите корректное значение.");
            }
        }
    }
}