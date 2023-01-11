// dev branch for Y.Practicum

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        firstStep();
        int persons = checkInput();
        Calculator calculator = new Calculator();
        List<Product> products = calculator.calculateBill();
        System.out.println("------------------------");
        Product.calculation(persons, sumTotal(products));

    }

    public static void firstStep() {
        System.out.println("Добрый день! Это консольное приложение пожет вам разделить счет");
        System.out.println("Введите количество персон");
    }

    public static int checkInput() {
        Scanner scanner = new Scanner(System.in);

        int input;
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Введите число виде числа персон!");
                scanner.next();
                continue;
            } else input = scanner.nextInt();

            if (input <= 1) {
                System.out.println("Ошибка! Введите количество персон больше 1 человека");
                continue;
            }

            break;
        }
        return input;
    }

    public static double sumTotal(List<Product> productList) {
        double total = 0;
        for (Product product : productList) {
            total = total + product.price;
            String text = "Позиция - " + product.name + " по цене " + product.price;
            System.out.println(text);
        }
        return total;
    }


}
