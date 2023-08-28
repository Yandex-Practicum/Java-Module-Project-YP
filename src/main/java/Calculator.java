
import java.util.Locale;
import java.util.Scanner;
public class Calculator {

    public void newProduct(int people) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double sumProduct = 0.00;
        double moneyProduct = 0.00;
        double money = 0.00;
        String listProduct = "Добавленные товары:";
        while (true) {
            Product product = null;
            System.out.println("Что бы добавить товар напишите название товара.\nЕсли вы хотите завершить добавление товаров, напишите (Завершить).");
            String nameProduct = scanner.next();
            if (nameProduct.equalsIgnoreCase("Завершить")) {
                if (sumProduct == 0) {
                    System.out.println("Вы не добавили товары.");
                } else {
                    break;
                }
            } else {
                System.out.println("Введите пожалуйста цену товара формата(рубли.копейки).");
                while (true) {
                    try {
                        moneyProduct = scanner.nextDouble();
                        if (moneyProduct <= 0) {
                            System.out.println("Введите цену больше 0");
                        }
                        if (moneyProduct > 0) {
                            product = new Product(nameProduct, moneyProduct);
                            System.out.println("Товар успешно добавлен!");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Неверная цена");
                        System.out.println("Введите пожалуйста цену товара формата(рубли.копейки).");
                        scanner.nextLine();
                    }
                }
            }
            if (product != null) {
                sumProduct = sumProduct + product.moneyProduct;
                listProduct = listProduct + "\n" + product.nameProduct;
                money = sumProduct / people;
            }
        }
        Formatter form = new Formatter();
        System.out.println(listProduct);
        System.out.println(String.format("С каждого человека по %s", form.format(money)));
    }
}