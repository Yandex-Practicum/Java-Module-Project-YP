import java.util.Scanner;
import java.util.ArrayList;
public class Calculator {
    private double totalCoast;

    public void setTotalCoast(double totalCoast) {
        this.totalCoast = totalCoast;
    }

    public double getTotalCoast() {
        return totalCoast;
    }

    public void calculateTotalCost() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        double totalBill = 0.0;
        boolean continueAdding = true;

        while (continueAdding) {
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
                    if (price <= 0) {
                        System.out.println("Продукта успешно добавлен в калькулятор.");
                        continue;
                    }
                    totalBill += price;
                    products.add(productName);
                    System.out.println("Продукта успешно добавлен в калькулятор.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка. Пожалуйста, введите число в формате рубли.копейки.");
                }
            }

            boolean validInput;
            do {
                System.out.print("Хотите добавить ещё один товар? (Да/Нет): ");
                String continueInput = scanner.nextLine().toLowerCase();

                if (continueInput.equals("да")) {
                    continueAdding = true;
                    validInput = true;
                } else if (continueInput.equals("нет")) {
                    continueAdding = false;
                    validInput = true;
                } else {
                    System.out.println("Ошибка. Пожалуйста, введите \"Да\" или \"Нет\".");
                    validInput = false;
                }
            } while (!validInput);

            String rublesSuffix = RubleUtil.getRublesFormattedString(totalBill);

            System.out.println("Общая стоимость всех товаров: " + totalBill + " " + rublesSuffix);

            System.out.println("Добавленные товары:");
            for (String product : products) {
                System.out.println(product);
            }

            totalCoast = totalBill;
        }
    }
}
