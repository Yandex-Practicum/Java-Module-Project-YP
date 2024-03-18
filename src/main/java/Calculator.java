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

            System.out.print("Введите стоимость товара в формате рубли.копейки: ");
            double productCost = Double.parseDouble(scanner.nextLine());

            totalBill += productCost;
            products.add(productName);

            System.out.println("Товар успешно добавлен в калькулятор.");

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
            totalCoast = totalBill;
        }

    }
}