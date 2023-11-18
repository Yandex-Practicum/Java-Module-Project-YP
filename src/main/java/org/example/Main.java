package org.example;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int persons = getNumberOfPersons(scanner);

        ItemManager itemManager = new ItemManager();

        itemManager.takeUserInput(scanner);

        System.out.println("Добавленные товары:\n" + itemManager.getItemsList());
        System.out.printf("Общая стоимость для %d человек: %.2f руб%s\n", persons,
                itemManager.calculateTotalCost(persons), itemManager.getRussianEnding(persons));

        scanner.close();
    }

    private static int getNumberOfPersons(Scanner scanner) {
        int persons = 0;

        while (persons <= 1) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
                scanner.nextLine();
                if (persons <= 1) {
                    System.out.println("Некорректный ввод. Попробуйте ещё раз.");
                }
            } else {
                System.out.println("Некорректный ввод. Введите целое число.");
                scanner.next();
            }
        }
        return persons;
    }
}

class ItemManager {
    private double totalCost;
    private StringBuilder itemsList;

    public ItemManager() {
        totalCost = 0;
        itemsList = new StringBuilder();
    }

    public void takeUserInput(Scanner scanner) {
        String userInput;

        do {
            System.out.println("Введите название товара:");
            String nameEat = scanner.nextLine();

            System.out.println("Введите стоимость товара:");
            if (scanner.hasNextDouble()) {
                double costEat = scanner.nextDouble();
                scanner.nextLine();

                totalCost += costEat;
                itemsList.append("Товар ").append(nameEat).append(" стоимостью ").append(costEat).append(" добавлен!\n");

                System.out.println("Хотите добавить еще товар? (Введите 'Завершить' для завершения, или что-нибудь для продолжения)");
                userInput = scanner.nextLine().toLowerCase();
            } else {
                System.out.println("Некорректный ввод. Введите стоимость в правильном формате.");
                scanner.nextLine();
                userInput = "";
            }
        } while (!userInput.equals("завершить"));
    }

    public String getItemsList() {
        return itemsList.toString();
    }

    public double calculateTotalCost(int persons) {
        return totalCost / persons;
    }

    public String getRussianEnding(int persons) {
        return ((persons == 1 || persons % 10 == 1 && persons % 100 != 11) ? "ль" : "ля");
    }
}
