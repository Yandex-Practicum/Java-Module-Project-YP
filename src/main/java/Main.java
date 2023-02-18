import java.text.DecimalFormat;
import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0;
        DecimalFormat two = new DecimalFormat("#.##");
        int quantity;
        while (true) {
            System.out.println("На сколько человек разделить счет?");
            while (!scanner.hasNextInt()) {
                System.out.println("Введи целое число больше 1");
                scanner.next();
            }
            quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity == 1) {
                System.out.println("Нет смысла делить счет. Введи новое число");
            }
            if (quantity < 1) {
                System.out.println("Как может прийти меньше 1 человека?! Дурак) Введи снова");
            }
            if (quantity > 1) {
                System.out.println("Принимай заказ. Будем делить чек на " + quantity + "-х");
                break;
            }
        }
        StringBuilder totalName = new StringBuilder("Добавленные товары:\n");
        while (true) {
            System.out.println("Как называется блюдо?");
            String name = scanner.nextLine();
            double price = 0;
            System.out.println("Сколько стоит блюдо (формат ХХ.ХХ)?");
            while (price <= 0) {
                while (!scanner.hasNextDouble()) {
                    System.out.println("Введи число!");
                    scanner.next();
                }
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Введи нормальную стоимость");
                }
            }
            scanner.nextLine();
            totalPrice += price;
            totalName.append(name + "\n");
            System.out.println("Добавлено " + name + ". Его стоимость " + price + ". Хочешь добавить еще блюдо? Если нет - напиши завершить");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                System.out.println(totalName);
                break;
            }
        }
        double result = totalPrice / quantity;
        Formatter ruble = new Formatter();
        System.out.println("По счету каждый платит: " + two.format(result) + " " + Formatter.calc(result));
    }
}

// вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости