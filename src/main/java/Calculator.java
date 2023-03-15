import static java.lang.Math.floor;

import java.util.Scanner;

public class Calculator {
    static double totalAmount = 0.0;
    static StringBuilder foodNameList = new StringBuilder();


    public void calculate(int numberOfPerson) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название блюда:");
            String foodName = scanner.next();
            System.out.println("Введите стоимость товара: ");

            Product product = new Product(foodName, validateDoubleInput(scanner));
            foodNameList.append(foodName).append("\n");
            totalAmount = totalAmount + product.price;

            System.out.println("Товар добавлен");

            System.out.println(
                    "Хочешь добавить ещё один товар, пиши '+'. Если нет, то пиши 'завершить'"
            );
            String input = scanner.next();
            System.out.println("\n");

            if (input.equalsIgnoreCase("Завершить")) {
                Formatter formatter = new Formatter();
                int x = (int) Math.floor(totalAmount);
                String end_declension = formatter.GetRubleAddition(x);

                System.out.println("Добавленные товары: \n" + foodNameList);
                System.out.println("\n");
                System.out.printf("Общая стоимость: %.2f %s", totalAmount, end_declension);
                System.out.println("\n");

                double priceForOnePerson = totalAmount / numberOfPerson;
                x = (int) Math.floor(priceForOnePerson);
                end_declension = formatter.GetRubleAddition(x);
                System.out.printf("Счет на одного человека: %.2f %s", priceForOnePerson, end_declension);

                scanner.close();
                break;
            }
        }
    }


    public static double validateDoubleInput(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.println("Некорректное значение, введите цифру с плавающей запятой");
            input.next();
        }
        return input.nextDouble();
    }
}

