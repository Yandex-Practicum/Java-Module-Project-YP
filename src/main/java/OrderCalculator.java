import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderCalculator {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    double totalCost = 0;

    public void start() {
        System.out.print("Hа скольких человек необходимо разделить счёт: ");

        int amountOfGuests = amountOfGuestsValidation();

        while (true) {
            String productName = nameOfProductValidation();
            double productCost = costOfProductValidation();

            Product product = new Product(productName, productCost);
            products.add(product);
            totalCost = totalCost + productCost;
            System.out.println("Добавлен товар: " + productName + ", цена: " + productCost);

            System.out.println("Добавить товар?");
            String command = scanner.next();

            if (command.equalsIgnoreCase("завершить")) {
                printAllProducts();
                printTotalPerGuest(amountOfGuests);
                System.out.println("Выход из программы");
                break;
            }
        }
    }

    private int amountOfGuestsValidation() {
        int amountOfGuests = 0;
        boolean isRightType = false;
        while (!isRightType) {
            try {
                amountOfGuests = scanner.nextInt();
                if (amountOfGuests <= 1) {
                    System.out.println(amountOfGuests + " - некорректное значение для подсчёта");
                    System.out.print("введите количество гостей: ");
                } else {
                    isRightType = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("Неверно указано количество гостей, введите количество еще раз: ");
                scanner.next();
            }
        }
        return amountOfGuests;
    }

    private String nameOfProductValidation() {
        System.out.print("Добавить название товара: ");
        return scanner.next();
    }

    private double costOfProductValidation() {
        double productCost = 0;
        boolean isRightType = false;
        System.out.print("Добавить цену товара: ");

        while (!isRightType) {
            try {
                productCost = scanner.nextDouble();
                if (productCost > 0) {
                    isRightType = true;
                } else {
                    System.out.print("Цена товара не может быть отрицательным числом, введите цену еще раз: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Неверно указана цена товара, введите цену еще раз: ");
                scanner.next();
            }
        }
        return productCost;
    }

    private void printAllProducts() {
        System.out.println("Добавленные товары: ");
        for (Product product : products) {
            System.out.println(product.productName);
        }
    }

    private void printTotalPerGuest(int amountOfQuests) {
        String rubCase;

        double totalPerGuest = totalCost / amountOfQuests;
        int lastDigid = ((int) totalPerGuest) % 10;

        if (lastDigid == 1 && !(totalPerGuest >= 10 && totalPerGuest <= 20)) {
            rubCase = "рубль";
        } else if ((lastDigid >= 2 && lastDigid < 5) && !(totalPerGuest >= 10 && totalPerGuest <= 20)) {
            rubCase = "рубля";
        } else {
            rubCase = "рублей";
        }

        System.out.println("Сумма, которую должен заплатить каждый гость: "
                + String.format("%.2f", totalPerGuest) + " " + rubCase);
    }
}