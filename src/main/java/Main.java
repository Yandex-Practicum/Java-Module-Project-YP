import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people;

        do {
            System.out.println("На скольких человек необходимо разделить счет?");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Введено некорректное значение, укажите другое количество человек: ");
            }
            people = sc.nextInt();
            if (people <= 1) {
                System.out.println("Значение должно быть больше одного.");
            }
        } while (people <= 1);

        Product product = new Product();
        double countProduct = product.count();

        double result = countProduct / people;

        String countCost = String.format("%.2f", countProduct);
        String resultCost = String.format("%.2f", result);
        System.out.println("Добавленные товары: " + product.getAllProducts());

        Rubles wordRejection = new Rubles();

        String rub = wordRejection.getRubles((int) Math.floor(countProduct));
        System.out.printf("Общая стоимость составила: " + countCost + " " + rub);

        rub = wordRejection.getRubles((int) Math.floor(result));
        System.out.printf("\nСтоимость на одного человека составляет: " + resultCost + " " + rub);
    }
}