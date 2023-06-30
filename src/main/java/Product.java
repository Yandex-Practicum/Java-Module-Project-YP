import java.util.InputMismatchException;
import java.util.Scanner;
public class Product {
    Scanner sc = new Scanner(System.in);
    String insertName(){
        return sc.next();
    }

    float insertPrice() {
        while(true) {

            try {
                float priceOfProduct = sc.nextFloat();
                if (!(priceOfProduct <= 0)) {
                    return priceOfProduct;
                }
                if (priceOfProduct == 0) {
                    System.out.println("Ваш товар бесплатный, пожалуй, мы не будем его добавлять в конечный список :с");
                    return priceOfProduct;
                }
                System.out.println("Вы ввели отрицательную цену, попробуйте еще раз:");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели что-то не то :с Попробуйте еще раз");
                sc.nextLine();
            }
        }
    }
}
