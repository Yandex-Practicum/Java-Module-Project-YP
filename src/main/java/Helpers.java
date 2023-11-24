import java.util.List;
import java.util.Scanner;

public class Helpers {
    int splitBetweenPeople(boolean isValid, Scanner scanner) {
        int people = 0;
        System.out.println("На сколько человек будем делить счёт?");
        while (!isValid) {
            if (!(scanner.hasNextInt())) {
                System.out.println("Так поделить не получится. Введите целое число.");
                scanner.next();
            } else if (Integer.parseInt(scanner.next()) < 2) {
                System.out.println("Так поделить не получится. Введите число больше единицы.");
                scanner.next();
            } else {
                people = scanner.nextInt();
                isValid = true;
            }
        }
        return people;
    }

    List<Product> addProducts(boolean isAddingNewProduct,
                                 Scanner scanner,
                                 List<Product> productList) {
        while (!isAddingNewProduct) {
            System.out.println("Введите название продукта:");
            String productName = scanner.next();
            System.out.println("Введите цену продукта в рублях с копейками:");
            boolean doubleInput = false;
            while (!doubleInput) {
                if (!(scanner.hasNextDouble())) {
                    System.out.println("Введите цену продукта в рублях с копейками:");
                    scanner.next();
                } else if (Double.parseDouble(scanner.next()) <= 0.0) {
                    System.out.println("Введите цену выше нуля:");
                    scanner.next();
                } else {
                    doubleInput = true;
                }
            }
            double productPrice = Double.parseDouble(scanner.next());
            Product product = new Product(productName, productPrice);
            productList.add(product);
            System.out.println("Продукт успешно добавлен!");
            System.out.println("Если желаете добавить ещё один продукт, введите любой символ. В противном случае введите 'Завершить'");
            if (scanner.next().toLowerCase().equals("завершить")) {
                isAddingNewProduct = true;
            }
        }
        return productList;
    }
}
