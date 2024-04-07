import java.util.Scanner;
public class Main {

    public static int quantity;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Products products = new Products();
        Calculator prices = new Calculator();
        String product;
        float price;

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if(scanner.hasNextInt()){
                quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 1 ) {
                    break;
                } else {
                    System.out.println("Введите значение больше 1");
                }
            } else {
                System.out.println("Введите целое число");
                scanner.nextLine();
            }
        }

        String end = "";
        while (!end.equalsIgnoreCase("Завершить")) {
            System.out.println("Введите название блюда");
            product = scanner.nextLine();
            products.addProduct(product);
            while (true) {
                System.out.println("Введите цену блюда");
                if (scanner.hasNextFloat() ) {
                    price = scanner.nextFloat();
                    scanner.nextLine();
                    if(price > 0) {
                        prices.addPrice(price);
                        break;
                    } else {
                        System.out.println("Введите цену больше 0");
                    }
                } else {
                    System.out.println("введите цифровое значение");
                    scanner.nextLine();
                }
            }
            System.out.println("Товар успешно добавлен");
            System.out.println("Добавить новый товар или завершить?");
            end = scanner.nextLine();
        }
        System.out.println("Добавленные товары:");
        products.outputProducts();
        prices.samib();
        scanner.close();
    }
}