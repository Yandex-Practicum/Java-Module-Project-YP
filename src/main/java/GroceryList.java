import java.util.Scanner;

class GroceryList {

    public static double Product(Scanner nameProduct) {

        double sum = 0.0;
        StringBuilder products = new StringBuilder(("Добавить блюда")); //Обьявить блюда

        while (true) {
            String name;
            System.out.println("Введите название блюда. Либо напишите 'Завершить'."); // Ввести название блюда
            name = nameProduct.next();

            if (name.equalsIgnoreCase("Завершить")) { //Подсчет итога
                System.out.println(products);
                break;
            }

            double price;
            System.out.println("Введите стоимость блюда"); // Ввести стоимость
            while (!nameProduct.hasNextDouble()) {
                System.out.println("Введите стоимость блюда в формате: 11,11");
                nameProduct.next();
            }
            price = nameProduct.nextDouble();

            if (price > 0) {
                products.append("\n").append(name).append(" по цене ").append(price);
                sum += price;
                System.out.println("Блюдо добавлено");
            }
        }
        return sum;
    }
}