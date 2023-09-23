import java.util.Scanner;
public class Calculator {
    Scanner scanner = new Scanner(System.in);
    double sum;
    String goodsList = "";
    String currency;

    void addGoods() {
        while (true) {
            System.out.println("Введите название товара: ");
            String addProduct = scanner.next();
            goodsList = goodsList + "\n" + addProduct;

            System.out.println("Введите цену товара:");
            double productPrice = scanner.nextDouble();
            sum += productPrice;

            System.out.println("Товар успешно добавлен!");
            System.out.println("Хотите добавить еще один товар? Если нет, введите \"Завершить\"");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    void calculatePayment(int numberOfPersons) {
        System.out.println("Добавленные товары:\n" + goodsList);
        double sumPerPerson = sum / numberOfPersons;
        String sumToPay = String.format("Сумма к оплате на человека: %.2f", sumPerPerson);
        int lastNumber = (int)Math.floor(sumPerPerson) % 10;
        if ((int)Math.floor(sumPerPerson) > 10 && (int)Math.floor(sumPerPerson) < 21) {
            currency = " рублей.";
        } else if (sumPerPerson == 1) {
            currency = " рубль.";
        } else if (lastNumber <= 4 && lastNumber > 1) {
            currency = " рубля.";
        }else {
            currency = " рублей.";
        }
        System.out.println(sumToPay + currency);
    }
}
