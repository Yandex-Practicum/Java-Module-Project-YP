import java.util.Scanner;
import java.util.ArrayList;
public class Products {
    private final ArrayList<String> products;
    private double totalCost;
    public Products() {
        products = new ArrayList<>();
        totalCost = 0.0;
    }
    public void listProd() {
        Scanner scanner = new Scanner(System.in);
        String nameOfProduct;
        double cost;
        System.out.println("Введите наименование товара или 'Завершить' для окончания ввода: ");
        nameOfProduct = scanner.nextLine();
        while (!nameOfProduct.equalsIgnoreCase("завершить")) {
            System.out.print("Введите цену товара в формате руб.коп: ");
            try {
                cost = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод цены. Пожалуйста, введите число.");
                continue;
            } if (cost < 0) {
                System.out.println("Отрицательная цена не допускается.");
                continue;
            }
            products.add(nameOfProduct);
            totalCost += cost;
            System.out.print("Введите наименование товара или 'Завершить' для окончания ввода: "); nameOfProduct = scanner.nextLine();
        }
        scanner.close();
        System.out.println("Список товаров: ");
        for (String item : products) {
            System.out.println(item);
        }
    }
    public double getTotalCost() {

        return totalCost;
    }
    public static String Suf1(double totalCost) {
        if (totalCost % 100 >= 11 && totalCost % 100 <= 14) {
            return "ей";
        } else if (totalCost % 10 == 1) {
            return "ь";
        } else if (totalCost % 10 == 2 || totalCost % 10 == 3 || totalCost % 10 == 4) {
            return "я";
        }
        else {
            return "ей";
        }
    }

}
