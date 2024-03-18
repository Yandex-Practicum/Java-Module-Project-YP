
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счет?");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Ошибка. Введите число.");
        }
        int namber = scanner.nextInt();
        while (namber < 1) {
            System.out.println("Ошибка. Попробуйте ввести новое значение.");
            namber = scanner.nextInt();
        }
        if (namber == 1) {
            System.out.println("В этом случае нет смысла в вычислениях.");

        }
        NamberPerson nPerson = new NamberPerson();
        nPerson.setPerson(namber);
        nPerson.isPerson();
        Calculator calculator = new Calculator();
        calculator.Xerson();


        System.out.println("Добавленные товары:");

        System.out.println("Общая сумма: " + String.format("%.2f", calculator.getTotalCoast()) + " рубля");

        double individualPayment = calculator.getTotalCoast() / nPerson.getPerson();
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", individualPayment) + " рубля");

    }
}

//  Работу сдал Максим Грузинцев
