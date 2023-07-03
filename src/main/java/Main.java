import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Введите число гостей (от 2 человек):");

        int guests = 0;
        try {
            guests = myObj.nextInt();
            myObj.nextLine(); // Очистка буфера после чтения числа
        } catch (NumberFormatException e) {
            System.out.println("Некорректное число гостей");
            return;
        }

        if (guests <= 1) {
            System.out.println("Некорректное число гостей");
            return;
        }

        System.out.println("Введенное количество гостей: " + guests);
        double totalGoods = 0;
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Введите название товара:");
            String itemName = myObj.nextLine();

            if (itemName.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.println("Введите стоимость товара:");
            double itemPrice = 0;
            try {
                itemPrice = Double.parseDouble(myObj.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверная цена товара");
                return;
            }

            if (itemPrice <= 0) {
                System.out.println("Неверная цена товара");
                return;
            }

            Item item = new Item(itemName, itemPrice);
            items.add(item);
            totalGoods += itemPrice;
            System.out.println("Добавлен товар: " + itemName + ", Цена: " + itemPrice);
            System.out.println("Хотите ли добавить еще товар? (Введите 'Завершить', чтобы закончить)");
        }

        System.out.println("Список товаров:");
        for (Item item : items) {
            System.out.println(item.getName() + ", Цена: " + item.getPrice());
        }

        double result = totalGoods / guests;
        System.out.printf("Сумма на человека: %.2f %s", result, rubleEnding(result));
    }

    public static String rubleEnding(double amount) {
        int rubles = (int) amount;
        if (rubles % 10 == 1 && rubles % 100 != 11) {
            return "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}