import java.util.*;

public class Calculator {
    Format format = new Format();
    ArrayList<Product> products = new ArrayList<>();

    public void account(int userInput) {
        double sum = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите наименование товара");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавленные товары:\n" + products);
                System.out.println("Каждый человек должен заплатить " + format.format(sum / userInput));
                break;
            }
            System.out.println("Введите его стоимость.\nСтоимость должна быть в формате 10,45");
            double price = scanner.nextDouble();
            sum += price;
            products.add(new Product(name, price));
            System.out.println("Товар успешно добавлен, хотите добавить еще один?\nЕсли нет, то для завершения введите('Завершить')");
        }
    }
}