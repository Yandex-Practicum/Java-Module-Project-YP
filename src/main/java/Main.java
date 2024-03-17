import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    float price;

    Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " " + price;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productArray = new ArrayList<Product>();
        int numberOfGuests = 0;
        System.out.println("Введите количество людей, на количество которых необходимо будет разделить счет");
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfGuests = scanner.nextInt();
                if (numberOfGuests < 1) {
                    System.out.println("Ошибка, введите правильное количество");
                } else if (numberOfGuests == 1) {
                    System.out.println("Делить ничего не нужно, конец программы");
                    return;
                } else {
                    System.out.println("Количество гостей: " + numberOfGuests);
                    break;
                }
            } else {
                System.out.println("Ошибка, введите целочисленное числовое значение");
                scanner.next(); // Очистка буфера сканнера
            }
        }
        scanner.nextLine(); // Очистка буфера после ввода числа
        float prodSum = 0;
        while (true) {
            System.out.println("Введите название товара или \"Завершить\" для завершения:");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите цену товара:");
            while (true) {
                if (scanner.hasNextFloat()) {
                    float price = scanner.nextFloat();
                    scanner.nextLine(); // Очистка буфера после ввода числа
                    if (price <= 0) {
                        System.out.println("Неверное значение стоимости, повторите ввод");
                    } else {
                        productArray.add(new Product(name, price));
                        prodSum += price;
                        System.out.println("Товар с названием \"" + name + "\" добавлен");
                        break;
                    }
                } else {
                    System.out.println("Ошибка, введите числовое значение");
                    scanner.next(); // Очистка буфера сканнера
                }
            }
        }

        System.out.println("Добавленные товары:");
        for (int i = 0; i < productArray.size(); i++) {
            System.out.println(productArray.get(i).toString());
        }

        float priceForEach = prodSum / numberOfGuests;
        int lastDigit = (int) priceForEach % 10; // Получение последней цифры цены
        String padezh = "0";
        switch (lastDigit) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: {
                padezh = "Рублей";
                break;
            }
            case 1: {
                padezh = "Рубль";
                break;
            }
            case 2:
            case 3:
            case 4: {
                padezh = "Рубля";
                break;
            }
        }
        System.out.println(String.format("Итого каждому заплатить: %.2f %s", priceForEach, padezh));
    }
}
