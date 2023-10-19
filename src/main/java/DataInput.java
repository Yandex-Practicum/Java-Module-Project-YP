
import java.util.ArrayList;
import java.util.Scanner;

public class DataInput {
    // Ввод кол-ва человек
    public int numberOfPeople (Scanner scanner) {
        int col;
        String s = "\nВведите целое число больше 1.", s1 = "На сколько человек необходимо разделить счёт:";
        do {
            System.out.println(s1);
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!" + s);
                scanner.next();
            }
            col = scanner.nextInt();
            if (col < 0) {
                System.out.println("Это отрицательное число!" + s);
            } else if (col == 0) {
                System.out.println("На 0 делить нельзя!" + s + "\n" + s1);
            } else if (col == 1) {
                System.out.println("Нет смысла делить. Весь счет оплачивать Вам!" + s);
            }
        } while (col <= 1);
        return col;
    }

    // Ввод товара
    public ArrayList<LineOfBill> productEntry (Scanner scanner) {
        ArrayList<LineOfBill> listOfProducts = new ArrayList<>();     // Массив для хранения содержимого строк счета
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
            LineOfBill lb = new LineOfBill(name, price);                // Создание объекта для хранения данных строки счета
            listOfProducts.add(lb);                                               // и добавление его в массив
            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить еще один товар?\nДля завершения процесса добавления товаров введите \"Завершить\":");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));
        return listOfProducts;
    }

    // Ввод и проверка цены
    private float enteringAndCheckingPrices (Scanner scanner) {
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
            if (strPrice[1].length() > 2) {                                     // Если в дробной части больше 2 знаков
                System.out.println("Многовато копеек!" + s);
                price = 0.0f;
            }
        } while (price <= 0);
        return price;
    }
}