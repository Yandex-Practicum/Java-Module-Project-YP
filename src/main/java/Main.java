import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("На скольких человек необходимо разделить счёт?");

        int amount;

        while (true) {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {

                while (true) {

                    amount = sc.nextInt();

                    if (amount < 1) {
                        System.out.println("Это некорректное значение для подсчёта.");
                    } else if (amount == 1) {
                        System.out.println("Деление счёта бессмыслено :)");
                    } else {
                        System.out.println("Введите наименование товара и стоимость товара в формате рубли.копейки, например 'Цезарь 250.70'. Для окончания подсчета введите 'Завершить'");

                        Product newProduct = new Product();
                        Calculator newCalculator = new Calculator();

                        sc.nextLine();
                        while (true) {

                           String userAnswer = sc.nextLine();

                           if (userAnswer.equalsIgnoreCase("завершить") != true) {

                               newProduct.addProductArray(userAnswer);
                               String[] productName = userAnswer.split(" ");
                               newCalculator.setAllProductPrice(newProduct.getProductPrice(productName));

                               System.out.println("Товар успешно добавлен в список");
                               System.out.println("Хотите добавить еще товар или завершить подсчёт? Для окончания подсчета введите 'Завершить'");
                           }

                           else {
                               break;
                           }
                        }

                        System.out.println("Добавленные товары:");

                        ArrayList <String> newProductList = new ArrayList<>(newProduct.getProductArray());

                        for (String eachProduct: newProductList) {
                            System.out.println(eachProduct);
                        }

                        System.out.println("Сумма к оплате каждого гостя: " + newCalculator.getGuestBill(amount));
                        break;
                    }
                }


            }

            else {
                System.out.println("Неправильный ввод. Введите корректное цифровое значение");

            }
        }



    }

}