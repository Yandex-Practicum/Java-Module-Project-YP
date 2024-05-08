import java.util.ArrayList;
import java.util.Scanner;

public class Calc { //класс для подсчёта товаров

    ArrayList<Product> productList = new ArrayList<>();
    public static float addProduct(float sum, Scanner scanner,ArrayList<Product> productList) {
        Padesh padesh = new Padesh();
        while(true) { //Заполнение списка
            String name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")) { //проверка на завершение
                break;
            }
            if (scanner.hasNextFloat()) { //Проверка на ошибку ввода букв
                float price = scanner.nextFloat();
                if (price > 0) { //Проверка на норм цену
                    Product newproduct = new Product(name, price);//создание товара
                    productList.add(newproduct);
                    sum += price;
                    String messageTemplate = "Товар успешно добавлен! Сумма всех товаров: %.2f %s.";
                    System.out.println(String.format(messageTemplate, sum, padesh.padesh(sum)));
                    System.out.println("Хотите добавить ещё один товар?\nЕсли нет, то напишите 'Завершить'.");
                } else {
                    System.out.println("Ошибка! Цена товара должна быть больше нуля. Введите название и цену повторно:");
                }
            }else {
                System.out.println("Ошибка! Цена товара должна быть больше нуля. Введите название и цену повторно:");
                scanner.next();
            }
        }
        return sum;
    }

}