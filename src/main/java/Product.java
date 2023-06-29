import java.util.InputMismatchException;
import java.util.Scanner;
public class Product {
    Scanner sc = new Scanner(System.in);
    String insertName(){
        String nameOfProduct = sc.next();
        return nameOfProduct;
    }

    float insertPrice() {
        while(true) {

            try {
                float priceOfProduct = sc.nextFloat();
                if (!(priceOfProduct < 0)) {
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
