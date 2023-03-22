import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        double costPerPerson = totalValue / guests;
        String formattedCost = String.format("%.2f", costPerPerson);
        int rubles = (int) costPerPerson;
        String rubleSuffix;

        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            rubleSuffix = "рублей";
        } else if (lastDigit == 1) {
            rubleSuffix = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            rubleSuffix = "рубля";
        } else {
            rubleSuffix = "рублей";
        }

        System.out.println("Каждый гость должен заплатить " + formattedCost + " " + rubleSuffix + ".");
    }
}



