import java.util.Scanner;

public class Goods { // Создаем класс со статическими переменными, хранящие сумму заказа и названия товаров
    String name;
    double price;
    static double sum = 0;
    static String names = "";

    public Goods(String n, double p) {
        price = p;
        name = n;
        sum += price;
        names += "\n" + name;
    }

    public static void calculator() { // метод для добавления товаров
        Scanner scanner = new Scanner(System.in);
        String check = "0";
        while (check.toLowerCase() != "завершить") {
            if (check.toLowerCase().equals("завершить")) break;
            else {
                String name;
                double price = -1;
                while (price < 0) {
                    System.out.println("Введите название товара:");
                    name = scanner.next();
                    System.out.println("Введите стоимость товар:");
                    while (!scanner.hasNextDouble()) {
                        scanner.next();
                        System.out.println("Что-то не так, попробуйте еще раз, но с цифрами!");
                    }
                    price = scanner.nextDouble();
                    if (price > 0) {
                        Goods nnew = new Goods(name, price);
                        break;
                    } else {
                        System.out.println("Неверный ввод! попробуйте еще раз");
                    }
                }
                System.out.println("Желаете продолжить? Для выхода введите 'завершить'");
                check = scanner.next();
            }
        }
    }
}
