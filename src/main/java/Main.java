import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();

        int guestAmount = inputHandler.handleGuestAmount();

        inputHandler.handleItemDescription(calculator);
        System.out.println(calculator.showAllItems());

        double sum = calculator.calculateAmountPerPerson(guestAmount);
        System.out.println(formatter.formatAmount(sum));
        scanner.close();
    }
}