import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Class<? extends String> Integer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счёт?");

        int amount;

        while (true) {


            if (sc.nextLine().getClass() != Integer) {

                System.out.println("Неправильный ввод. Введите корректное цифровое значение");

            }

            else {
                while (true) {
                    amount = java.lang.Integer.parseInt(sc.nextLine());

                    if (amount < 1) {
                        System.out.println("Это некорректное значение для подсчёта.");
                    } else if (amount == 1) {
                        System.out.println("Деление счёта бессмыслено :)");
                    } else {
                        System.out.println("Введите наименование товара и стоимость товара в формате рубли.копейки");
                        String userAnswer = sc.nextLine();
                        String[] productArrayName = userAnswer.split(" ");

                        while (userAnswer.equalsIgnoreCase("завершить") != true) {
                            Product nextProduct = new Product();
                            Product.addProductArray(userAnswer);
                            Calculator.setAllProductPrice(Product.getProductPrice(productArrayName));
                            System.out.println("Товар успешно добавлен в список");
                            System.out.println("Хотите добавить еще товар или завершить подсчёт? Для окончания подсчета введите 'Завершить'");
                        }
                        break;
                    }
                }
                break;
            }
        }

        System.out.println("Добавленные товары:");

        ArrayList <String> newProductList = new ArrayList<>(Product.getProductArray());
        for (String eachProduct: newProductList) {
            System.out.println(eachProduct);
        }
        Calculator newCalculator = new Calculator();
        System.out.println("Сумма к оплате каждого гостя: " + Calculator.getGuestBill(amount));


    }

}