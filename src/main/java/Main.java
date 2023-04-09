import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Calculator.getGuestsNumber(scanner);
        String itemList = Calculator.getItemsList(scanner);
        double costPerPerson = Calculator.getCostPerPerson(itemList, guests);

        String rubleSuffix = Calculator.getRubleSuffix(costPerPerson);
        System.out.println("Каждый гость должен заплатить " + String.format("%.2f", costPerPerson) + " " + rubleSuffix + ".");
    }
}

class Calculator {

    public static int getGuestsNumber(Scanner scanner) {
        int guests = 0;
        boolean guestsNum = false;
        while (!guestsNum) {
            System.out.print("Введите количество гостей: ");
            if (scanner.hasNextInt()) {
                guests = scanner.nextInt();
                if (guests <= 1) {
                    System.out.println("Некорректное значение. Количество гостей должно быть больше 1.");
                } else {
                    guestsNum = true;
                }
            } else {
                System.out.println("Введите корректное число!");
                scanner.next();
            }
        }
        return guests;
    }

    public static String getItemsList(Scanner scanner) {
        double totalValue = 0.0;
        boolean isGoodsEnough = true;
        String itemList = "";
        while (isGoodsEnough) {
            System.out.print("Введите название товара: ");
            String itemName = scanner.next();

            boolean validCost = false;
            while (!validCost) {
                System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
                if (scanner.hasNextDouble()) {
                    double itemCost = scanner.nextDouble();
                    if (itemCost >= 0) {
                        totalValue += itemCost;
                        itemList += itemName + " - " + String.format("%.2f", itemCost) + " руб." + "\n";
                        System.out.println("Товар " + itemName + " успешно добавлен.");
                        validCost = true;
                    } else {
                        System.out.println("Стоимость товара не может быть отрицательной.");
                    }
                } else {
                    System.out.println("Введите корректное число!");
                    scanner.next();
                }
            }

            System.out.print("Хотите добавить ещё один товар? (Введите \"Завершить\", чтобы закончить): ");
            String userChoice = scanner.next();
            if (userChoice.equalsIgnoreCase("Завершить")) {
                isGoodsEnough = false;
            }
        }

        System.out.println("Добавленные товары: ");
        System.out.println(itemList);
        return itemList;
    }

    public static double getCostPerPerson(String itemList, int guests) {
        double totalValue = 0;
        String[] items = itemList.split("\n");
        for (String item : items) {
            String costString = item.substring(item.lastIndexOf(" ") + 1, item.lastIndexOf(" руб."));
            totalValue += Double.parseDouble(costString);
        }
        return totalValue / guests;
    }

    public static String getRubleSuffix(double costPerPerson) {
        int rubles = (int) costPerPerson;
        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "рублей";
        } else if (lastDigit == 1) {
            return "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
