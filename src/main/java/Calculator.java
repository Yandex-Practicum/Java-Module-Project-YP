import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void calculate(int howMany) {
        Locale.setDefault(new Locale("us", "ru"));

        Scanner scanner = new Scanner(System.in);
        List<String> savedNames = new ArrayList<>();
        List<Double> savedCost = new ArrayList<>();
        double sum = 0;

        while (true) {
            System.out.println("Введите название:");
            String name = scanner.next();
            savedNames.add(name);

            System.out.println("Введите стоимость товара в формате рубли.копейки:");
            double cost;

            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка! Введите заново:");
                scanner.next();
            }

            cost = scanner.nextDouble();

            if (cost > 0) {
                savedCost.add(cost);
                sum = cost + sum;
                System.out.println("Товар успешно добавлен!");

                System.out.println("Хотите ли вы продолжить? Напишите \"Да\", чтобы продолжить или напишите слово \"Завершить\" чтобы завершить расчет.");
                String endWord = scanner.next();
                if (endWord.equalsIgnoreCase("Завершить")) {
                    break;
                }
            } else {
                System.out.println("Стоимость товара не может быть равна 0 или быть отрицательным числом!");
            }
        }

        double totalSum = sum / howMany;

        System.out.println("Добавленные товары:");
        for (int i = 0; i < savedNames.size() && i < savedCost.size(); i++) {
            double cost = savedCost.get(i);
            String formattedCost = String.format("%.2f %s", cost, RubleFormatter.rightForm(cost));
            System.out.println(savedNames.get(i) + " - " + formattedCost);
        }
        System.out.println("-------------------------------");
        System.out.printf("Каждый человек должен заплатить: %.2f %s", totalSum, RubleFormatter.rightForm(totalSum));
        scanner.close();
    }
}