import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner scanner = new Scanner(System.in);
    double sum = 0;
    int persons = 0;

    public void calculate() {
        while (true) {
            System.out.println("Введите название товара");
            String name = scanner.next();
            if (name.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара");
            double price;
            try {
                price = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Вы ввели неверную цену. Давайте попробуем еще");
                continue;
            }
            Product product = new Product(name, price);
            products.add(product);
            System.out.println("Товар успешно добавлен. Хотите добавить еще?");
        }
        System.out.println("fin");
        this.computeSum();
        this.printResults();
    }

    public void computeSum() {
        for (Product product: this.products) {
            this.sum += product.price;
        }
    }

    public double computePay() {
        return this.sum / this.persons;
    }

    public void printResults() {
        System.out.println("Добавленные товары:");
        for (Product product: this.products) {
            System.out.println(product.name + " " + product.price);
        }
        if (this.sum == 0) {
            this.computeSum();
        }
        double pay = this.computePay();
        String rub = "рублей";
        int last = (int)(Math.floor(pay)) % 10;

        if (last == 1) {
            rub = "рубль";
        }
        if (last >= 2 && last <= 4) {
            rub = "рубля";
        }

        System.out.println("Каждый должен заплатить: " + String.format("%.2f",pay) + " " + rub);
    }
}
