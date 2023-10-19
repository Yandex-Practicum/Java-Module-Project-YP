import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счет?");
        int people = sc.nextInt();

        while (people <= 1) {
            System.out.print("Некорректное значение \nУкажите другое количество человек:");
            people = sc.nextInt();
        }

        Product product = new Product();
        double countProduct = product.count();

        double result = countProduct / people;

        String countCost = String.format("%.2f", countProduct);
        String resultCost = String.format("%.2f", result);
        System.out.println("Добавленные товары: " + product.getAllProducts());

        Rubles rubles = new Rubles();
        String rub = rubles.getRubles();

        System.out.println("Общая стоимость составила: " + countCost + " " + rub);
        System.out.print("Стоимость на одного человека составляет: " + resultCost + " " + rub);
    }
}