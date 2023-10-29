import java.util.Scanner;

public class Calculator {
    static double productPrice;
    static double totalPrice;
    static String productNames;
    static String sumListOfProduct = new String();
    static double rubPerPerson;
    static String totalPriceOkr;

    public static double productPrice() {
        Scanner scanPrice = new Scanner(System.in);
        while (true) {
            if (scanPrice.hasNextDouble()) {
                productPrice = scanPrice.nextDouble(); {
                    if (productPrice < 0) {
                        System.out.println("Введено отрицательное число, повторите ввод");
                    } else {
                        totalPrice = totalPrice + productPrice;
                        totalPriceOkr = String.format("%.2f", totalPrice);
                        return productPrice;
                    }
                }

            } else if (!scanPrice.hasNextDouble()) {
                System.out.println("Введено некорректное число, повторите ввод");
                scanPrice.next();
            }
        }
    }
    public static String listOfProduct() {
        Scanner scanProductNames = new Scanner(System.in);
        productNames = scanProductNames.nextLine();

            sumListOfProduct += "\n" + productNames;
            System.out.println("Товар " + productNames + " успешно добавлен в корзину");
            System.out.println("В корзину добавлены следующие товары: " + sumListOfProduct);

        return sumListOfProduct;
    }
    public static void finalResult() {

        while (true) {
            System.out.println("Список добавленных торваров:" + sumListOfProduct);
            System.out.println("Общая сумма добавленных товаров: " + totalPriceOkr  + " " + RubFormat.RubFormatAdd());
            System.out.println("Сумма с каждого человека: " + (String.format("%.2f", Calculator.rubPErPerson())) + " " + RubFormat.RubFormat());
            break;
        }

    }
    public static double rubPErPerson() {
        rubPerPerson = totalPrice/PeopleNumber.sumOfPeople;
        return rubPerPerson;
    }


}
