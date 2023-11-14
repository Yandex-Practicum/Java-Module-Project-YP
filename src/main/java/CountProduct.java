import java.util.Scanner;

public class CountProduct {
    Scanner scan = new Scanner(System.in);
    String allProduct = "Добавленные товары:\n";
    double allCost = 0;

    void input() {
        while (true) {
            System.out.println("Введите название товара:");
            String product = scan.next();
            System.out.println("Введите цену товара:");
            double cost = 0;

            while (true) {
                if (scan.hasNextDouble()) {
                    cost = scan.nextDouble();
                    if (cost > 0) {
                        count(product, cost);
                        break;
                    } else {
                        System.out.println("Ошибка. Введите целое число:");
                    }
                } else if (scan.hasNext()) {
                    System.out.println("Ошибка. Введите целое число:");
                    scan.next();
                }
            }
            System.out.println("Товар успешно добавлен. Хотите еще добавить?");
            String check = scan.next();
            if (check.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    void count(String product, double cost) {
        allProduct = allProduct + product + "\n";
        allCost = allCost + cost;
    }
}

