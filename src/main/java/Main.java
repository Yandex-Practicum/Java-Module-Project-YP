import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillCalculator calculator = new BillCalculator();

        System.out.println("На скольких человек необходимо разделить счёт?");
        int peopleCount;
        while (true) {
            try {
                peopleCount = Integer.parseInt(scanner.nextLine());
                if (peopleCount > 1) {
                    calculator.setNumberOfPeople(peopleCount);
                    break;
                } else {
                    System.out.println("Введите корректное количество людей (больше 1):");
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
            }
        }

        while (true) {
            System.out.println("Введите название товара и его стоимость (или 'Завершить' для завершения):");
            String input = scanner.nextLine();
            if ("Завершить".equalsIgnoreCase(input)) {
                break;
            } else {
                try {
                    String[] parts = input.split(" ");
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    calculator.addProduct(new Product(name, price));
                    System.out.println("Товар '" + name + "' по цене " + price + " добавлен.");
                } catch (Exception e) {
                    System.out.println("Некорректный ввод, попробуйте еще раз.");
                }
            }
        }

        System.out.println("Добавленные товары:");
        calculator.getProducts().forEach(product -> System.out.println(product.getName() + " по цене " + product.getPrice()));
        System.out.println("Каждый должен заплатить: " + String.format("%.2f руб.", calculator.getAmountPerPerson()));
    }

    static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
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

    static class BillCalculator {
        private final List<Product> products = new ArrayList<>();
        private int numberOfPeople;

        public void setNumberOfPeople(int numberOfPeople) {
            this.numberOfPeople = numberOfPeople;
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public double getTotalAmount() {
            return products.stream().mapToDouble(Product::getPrice).sum();
        }

        public double getAmountPerPerson() {
            return getTotalAmount() / numberOfPeople;
        }

        public List<Product> getProducts() {
            return products;
        }
    }
}
