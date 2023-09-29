import java.util.Scanner;
public class Calculator {
    Scanner scanner = new Scanner(System.in);
    double sum;
    String goods = "";
    String currency;

    void addGoods() {
        while (true) {
            System.out.println("Введите название товара: ");
            String addProduct = scanner.next();
            goods = goods + addProduct + "\n" ;
            getPrice();
            System.out.println("Хотите добавить еще один товар? Если нет, введите \"Завершить\"");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    void getPrice() {
        while (true) {
            System.out.println("Введите цену товара:");
            if (scanner.hasNextDouble()) {
                double productPrice = scanner.nextDouble();
                if (productPrice > 0) {
                    sum += productPrice;
                    System.out.println("Товар успешно добавлен!");
                    break;
                } else {
                    System.out.println("Ошибка! Цена товара может быть только положительной!");
                }
            } else {
                System.out.println("Ошибка! Введите корректную цену товара!");
                scanner.next();
            }
        }
    }

    void calculatePayment(int numberOfPersons) {
        System.out.println("Добавленные товары:\n" + goods);
        double sumPerPerson = sum / numberOfPersons;
        String sumToPay = String.format("Сумма к оплате на человека: %.2f", sumPerPerson);
        int sumToInt = (int)Math.floor(sumPerPerson);
        int secondLastDigit = (sumToInt % 100) / 10;
        int lastDigit = sumToInt % 10;
        if (lastDigit == 1 && secondLastDigit != 1) {
            currency = " рубль.";
        } else if (lastDigit <= 4 && lastDigit > 1 && secondLastDigit != 1) {
            currency = " рубля.";
        }else {
            currency = " рублей.";
        }
        System.out.println(sumToPay + currency);
    }
}
