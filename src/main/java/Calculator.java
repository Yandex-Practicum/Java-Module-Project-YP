import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    private double totalCoast;
    void setTotalCoast(double totalCoast) {
        this.totalCoast = totalCoast;
    }
    public double getTotalCoast() {
        return totalCoast;
    }
    public void Xerson() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        double totalBill = 0.0;

        while (true) {
            System.out.print("Введите название товара (или 'Завершить' для завершения): ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }

            while (true) {
                System.out.print("Введите стоимость товара в формате рубли.копейки: ");
                String input = scanner.nextLine();

                try {
                    double price = Double.parseDouble(input);
                    totalBill += price;
                    products.add(productName);
                    System.out.println("Продукта успешно добавлен в калькулятор.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка. Пожалуйста, введите число в формате рубли.копейки.");
                }
            }

            System.out.print("Хотите добавить ещё один товар? (Да/Нет): ");
            String continueAdding = scanner.nextLine();

            if (!continueAdding.equalsIgnoreCase("Да")) {
                break;
            }
        }

        System.out.println("Общая стоимость всех товаров: " + totalBill);
        System.out.println("Добавленные товары:");
        for (String product : products) {
            System.out.println(product);
        }

        totalCoast = totalBill;
    }
}