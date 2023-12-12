import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        List<Product> products = new ArrayList<>();

        int personCount;

        while (true) {
            System.out.println("На скольких человек разделить счет?");
            personCount = Integer.parseInt(scanner.next());
            if (personCount < 1) {
                System.out.println("Неверное значение, введите число > 0");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Введите наименование товара: ");
            String productName = scanner.next();


            System.out.println("Введите стоимость товара: ");
            double cost = Double.parseDouble(scanner.next());

            if (cost <= 0.0) {
                System.out.println("Стоимость товара должна быть > 0");
                continue;
            }

            Product product = new Product();
            product.setName(productName);
            //product.name = productName;
            product.setCost(cost);
            //product.cost = cost;

            products.add(product);

            System.out.println("Желаете еще добавить товар? \nЕсли да, введите \"Да\" \nEсли нет, введите \"Завершить\"");
            String userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase("Да")) {
                continue;
            }
            if (userAnswer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

        System.out.println("Вы выбрали:");

        double totalCost = 0.0;
        for (Product product : products) {
            double cost = product.getCost();
            System.out.println(product.getName() + " " + String.format("%.2f", cost));
            totalCost += cost;

        }
        System.out.println("Итого: " + String.format("%.2f", totalCost));
        String dividedCost = calculator.divideCostByPersons(personCount, totalCost);
        System.out.println("Сумма на " + personCount + " человек: " + dividedCost);
    }
}




