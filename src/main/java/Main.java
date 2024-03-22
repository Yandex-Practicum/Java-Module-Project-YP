import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillCalculator billCalculator = null;
        Formatter formatter = new Formatter();
        int numberOfPeople = 0;
        while (true) {
            System.out.print("На сколько человек необходимо разделить счёт: ");
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople <= 1) {
                    System.out.println("Ошибка: Количество человек должно быть больше 1.");
                } else {
                    break;
                }
            } else {
                System.out.println("Ошибка: неправильный формат ввода, введите число.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите название продукта или напишите [Завершить]: ");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }

            System.out.print("Введите стоимость продукта в формате \"рубли,копейки\": ");
            double price = 0.00;
            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    if (price < 0) {
                        System.out.println("Ошибка: Стоимость товара не может быть отрицательной.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Ошибка: Введите число в формате \"рубли,копейки\".");
                    scanner.nextLine();

                }
            }
            if (billCalculator == null) {
                billCalculator = new BillCalculator(price, numberOfPeople);
            } else {
                billCalculator.addProduct(productName, price);
            }
            System.out.println("Продукт добавлен успешно.");
        }

        if (billCalculator != null) {
            System.out.println(billCalculator.getProductsList());
            System.out.println("Общий счёт: " + String.format("%.2f", billCalculator.getTotalBill()));
            System.out.println("Каждый человек должен заплатить: " + String.format("%.2f", billCalculator.calculatePerPersonBill()) + " " + formatter.formatAmount(billCalculator.calculatePerPersonBill()));
        } else {
            System.out.println("Не были добавлены продукты. Программа завершена.");
        }

        scanner.close();
    }
}
