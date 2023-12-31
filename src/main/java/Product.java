import java.util.Scanner;
import java.util.InputMismatchException;
public class Product {
    private String name;
    private double price;
    Scanner scanner = new Scanner(System.in);

    //КОНСТРУКТОР
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //СОЗДАНИЕ ПАРЫ БЛЮДО - ЦЕНА
    public static Product createProduct(Scanner scanner) {
        String name = scanner.nextLine();
        //ВВОД БЛЮДА
        while (true) {
            System.out.println("Введите название блюда");
            name = scanner.nextLine();

            if (!name.trim().isEmpty()) {
                break; // Если строка не пуста, выходим из цикла
            } else {
                System.out.println("Название блюда не может быть пустым. Попробуйте снова.\n");
            }
        }

        // ПРЕРЫВАНИЕ
        if (name.toLowerCase().equals("завершить")) {
            return null; // Возвращаем null, чтобы прекратить создание продуктов
        }

        double price = 0;

        //ВВОД ЦЕНЫ (с проверкой на корректныый ввод)
        while (true) {
            try {
                System.out.println("Введите цену блюда");
                price = scanner.nextFloat();
                //scanner.nextLine(); // ОЧИСТКА БУФЕРА ОБМЕНА ПОСЛЕ СЧИТЫВАНИЯ (float)
                if (price > 0) {
                    // ОКРУГЛЕНИЕ ДО ДВУХ ЗНАКОВ ПОСЛЕ ЗАПЯТОЙ
                    price = Math.round(price * 100.0) / 100.0;

                    // ПРЕРЫВАНИЕ (при успешном вводе)
                    break;
                } else {
                    System.out.println("\nЦена должна быть больше нуля.\n");
                }

                //ЛОВИМ ОШИБКУ НЕСОВПАДЕНИЯ ФОРМАТА
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите корректное число.");
                scanner.nextLine(); // ОЧИСТКА БУФЕРА ОБМЕНА ПОСЛЕ ОШИБОЧНОГО СЧИТЫВАНИЯ
            }
        }
        return new Product(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}