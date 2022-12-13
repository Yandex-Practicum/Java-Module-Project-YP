import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = 5;
        boolean isNumber = false;

        while (!isNumber) {
            System.out.println("На скольких человек необходимо разделить счёт?");// ваш код начнется здесь

            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                if (persons == 1) {
                    System.out.println("Нет смысла ничего считать и делить");
                } else if (persons < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                } else {
                    isNumber = true;
                }
            } else {
                System.out.println("Это неправильное число!");
                scanner.next();
            }
        }

        Calculator calculator = new Calculator();
        calculator.sumProduct();
        System.out.println(calculator.listProduct);

        double total = calculator.sum / persons;

        Ruble ruble = new Ruble();
        ruble.writeRuble(total);
        System.out.println(ruble.amountOfRubles);
    }
}