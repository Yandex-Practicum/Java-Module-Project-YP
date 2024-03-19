import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillCalculator billCalculator = null;
        Formatter formatter = new Formatter();
        int numberOfPeople = 0;
        while (true) {
            System.out.print("На скольких человек необходимо разделить счёт: ");
            numberOfPeople = scanner.nextInt();
            if (numberOfPeople == 1) {
                System.out.println("Ошибка: Невозможно разделить счет на 1 человека.");
            } else if (numberOfPeople < 1) {
                System.out.println("Ошибка: Количество человек должно быть больше, чем 1.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Введите название продукта или напишите [Завершить]: ");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }

            System.out.print("Введите стоимость продукта: ");
            double price = 0.00;

            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    if (price < 0) {
                        System.out.println("Стоимость товара не должна быть меньше нуля");
                    } else {
                        break;
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("Допустим ввод только чисел, введите повторно");
                }
            }
            if (billCalculator == null) {
                billCalculator = new BillCalculator(price, numberOfPeople);
            } else {
                billCalculator.addProduct(productName, price);
            }
            System.out.println("Продукт добавлен успешно.");
        }

        System.out.println(billCalculator.getProductsList());
        System.out.println("Общий счет: " + String.format("%.2f", billCalculator.getTotalBill()));
        System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", billCalculator.calculatePerPersonBill()) + " " + formatter.formatAmount(billCalculator.calculatePerPersonBill()));

        scanner.close();
    }
}
