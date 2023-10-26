import java.util.ArrayList;
import java.util.Scanner;

public class DataInput {
    // Ввод кол-ва человек
    public int numberOfPeople (Scanner scanner) {
        int numberOfPersons;
        final String STR_QUERY = "На сколько человек необходимо разделить счёт:";
        final String STR_NOTE = "\nВведите целое число больше 1.";
        do {
            System.out.println(STR_QUERY);
            while (!scanner.hasNextInt()) {
                System.out.println(new StringBuilder().append("Это не целое число!").append(STR_NOTE).append("\n").append(STR_QUERY));
                scanner.next();
            }
            numberOfPersons = scanner.nextInt();
            if (numberOfPersons < 0) {
                System.out.println(new StringBuilder().append("Это отрицательное число!").append(STR_NOTE));
            } else if (numberOfPersons == 0) {
                System.out.println(new StringBuilder().append("На 0 делить нельзя!").append(STR_NOTE));
            } else if (numberOfPersons == 1) {
                System.out.println(new StringBuilder().append("Нет смысла делить. Весь счет оплачивать Вам!").append(STR_NOTE));
            }
        } while (numberOfPersons <= 1);
        return numberOfPersons;
    }

    // Ввод товара
    public ArrayList<Product> productEntry (Scanner scanner) {
        final String STR_END_INPUT = "Завершить";                  // Кодовое слово для завершения ввода

        ArrayList<Product> listOfProducts = new ArrayList<>();     // Массив для хранения содержимого строк счета
        do {
            String name;
            float price;
            boolean empty;
            do {
                // Ввод наименования товара
                System.out.println("Введите наименование товара:");
                name = scanner.next();
                // Проверка, что строка не пустая. Кажется она не требуется (при пустой строке scanner будет повторять запрос на ввод), но на всякий случай
                empty = name.isEmpty();
                if (empty) {
                    System.out.println("У товара должно быть наименование, пустые строки не допускаются!");
                }
            } while (empty);
            // Ввод и проверка цены
            price = enteringAndCheckingPrices(scanner);
            Product lb = new Product(name, price);                // Создание объекта для хранения данных строки счета
            listOfProducts.add(lb);                                               // и добавление его в массив
            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить еще один товар?\nДля завершения процесса добавления товаров введите \"Завершить\":");
        } while (!scanner.next().equalsIgnoreCase(STR_END_INPUT));
        return listOfProducts;
    }

    // Ввод и проверка цены
    private float enteringAndCheckingPrices (Scanner scanner) {
        final int DIGITS_AFTER_DOT = 2;             // Максимальное кол-во цифр после десятичной точки

        float price;
        String s = "\nОжидается число больше 0 в формате \"0.00\".";
        String s1 = "Введите стоимость товара:";

        do {
            System.out.println(s1);
            // Проверка случайных символов
            while (!scanner.hasNextDouble()) {
                System.out.println("Это вообще не число!" + s + "\n" + s1);
                scanner.next();
            }
            price = scanner.nextFloat();
            // Проверка: цена > 0
            if (price == 0) {
                System.out.println("Бесплатный товар? Хмм..." + s);
            } else if (price <= 0) {
                System.out.println("Ого! Вы где нашли такие цены?" + s);
            }
            // Проверка - у цены должно быть две цифры после десятичной точки
            String[] strPrice = String.valueOf(price).split("\\.", 2);    // Разбиваем строку на массив из 2-х строк: целая часть и дробная
            if (strPrice[1].length() > DIGITS_AFTER_DOT) {                                     // Если в дробной части больше 2 знаков
                System.out.println("Многовато копеек!" + s);
                price = 0.0f;
            }
        } while (price <= 0);
        return price;
    }
}