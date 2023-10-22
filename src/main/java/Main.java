import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = 0;
        double value = 0;
        System.out.println("На какое количество гостей нужно разделить счёт?");
        while (scan.hasNext()) {
            if (!scan.hasNextInt()) {
                System.out.println("Ошибка! Пожалуйста, повторите ввод");
                scan.next();
            }
            if (scan.hasNextInt()) {
                people = scan.nextInt();
                if (people > 1) {
                    break;
                } else {
                    System.out.println("Ошибка, введите корректное количество гостей");
                    scan.hasNext();
                }
            }
        }
        Calculator number = new Calculator(people);
        while (true) {
            System.out.println("Введите название товара: ");
            String name = scan.next();
            System.out.println("Введите стоимость товара: ");
            while (scan.hasNext()) {
                if (!scan.hasNextDouble()) {
                    System.out.println("Ошибка! Пожалуйста, повторите ввод цены");
                    scan.next();
                }
                if (scan.hasNextDouble()) {
                    value = scan.nextDouble();
                    if (value > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка, введите корректную цену");
                        scan.hasNext();
                    }
                }
            }
            Product product = new Product(name, value);
            number.addMember(product);
            System.out.println("Товар успешно добавлен. Хотите добавить новый товар?");
            String result = scan.next();
            if (result.equalsIgnoreCase("Завершить")) {
                System.out.println("Каждый должен скинуться по: " + number.Cost());
                System.out.println("Добавленные товары: " + "\n" + number.names);
                break;
            }
        }
    }
}