import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests= 0;
        boolean guestsNum = false;
        while (!guestsNum) {
            System.out.print("Введите количество гостей: ");
            guests = scanner.nextInt();
            if (guests <= 1) {
                System.out.println("Некорректное значение. Количество гостей должно быть больше 1.");
            } else {
                guestsNum = true;
            }
        }

        double totalValue = 0.0;
        boolean isGoodsEnough = true;
        String itemList = "";
        while (isGoodsEnough) {
            System.out.print("Введите название товара: ");
            String itemName = scanner.next();

            System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
            double itemCost = scanner.nextDouble();

            totalValue += itemCost;
            itemList += itemName + " - " + itemCost + " руб." + "\n";
            System.out.println("Товар " + itemName + " успешно добавлен.");

            System.out.print("Хотите добавить ещё один товар? (Введите \"Завершить\", чтобы закончить): ");
            String userChoice = scanner.next();
            if (userChoice.equalsIgnoreCase("Завершить")) {
                isGoodsEnough = false;
            }
        }

        System.out.println("Добавленные товары:");
        System.out.println(itemList);

        double costPerPerson = totalValue / guests;
        String formattedCost = String.format("%.2f", costPerPerson);
        int rubles = (int) costPerPerson;
        String rubleSuffix;
        if (rubles == 1) {
            rubleSuffix = "рубль";
        } else if (rubles >= 2 && rubles <= 4) {
            rubleSuffix = "рубля";
        } else {
            rubleSuffix = "рублей";
        }
        System.out.println("Каждый гость должен заплатить " + formattedCost + " " + rubleSuffix + ".");
    }
}

