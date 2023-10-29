import java.util.Scanner;

public class Product {
    public static String Product() {

        while (true) {

            System.out.println("Введите название продукта");
            Calculator.listOfProduct();
            if (Calculator.productNames.equalsIgnoreCase("завершить")) {
                Calculator.finalResult();
                break;
            }

            System.out.println("Введите стоимость товара в формате рубли.копейки");
            Calculator.productPrice();

            System.out.println("Товаров в корзине на сумму " + (String.format("%.2f", Calculator.totalPrice)) + " " + RubFormat.RubFormatAdd());
            System.out.println("Товары в корзине: " + Calculator.sumListOfProduct);
            System.out.println("Хотите ли добавить еще товар?");
           // if (end()); {
            //    break;
            //}


        }
        return null;
    }
}
