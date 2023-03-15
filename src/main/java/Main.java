import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек разделить счет?");
        while (true) {
            int numberOfPerson = validateIntegerInput(scanner);

            if (numberOfPerson == 1) {
                System.out.println("Нет возможности разделить счет, пожалуйста, оплатите счет!");
            } else if (numberOfPerson < 1) {
                System.out.println("Некорректное значение");
            } else {
                System.out.println("Делим счет на " + numberOfPerson);
                Calculator calculator = new Calculator();
                calculator.calculate(numberOfPerson);
                scanner.close();
                break;
            }
        }
    }

    public static int validateIntegerInput(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Некорректное значение, введите цифру");
            input.next();
        }
        return input.nextInt();
    }

}
