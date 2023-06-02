
import java.util.Scanner;


public class Stuff {


    public static String name() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static double priceStuf(String name) {
        Scanner scanner = new Scanner(System.in);
        String keyWOrd1 = "завершить";
        double price = 0;


        if (name.equalsIgnoreCase(keyWOrd1)) {

            return 0;
        } else {


            while (!scanner.hasNextDouble()) {
                System.out.println("Допустимы только цифры, попробуйте еще раз");
                scanner.next();
            }


            while (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Допустимы только положительные значения, попробуйте еще раз");
                }else {
                    System.out.println("Добавлено успешно");
                    System.out.println("Что нибудь еще?");
                    return price;
                }
            }

        }
        return price;

    }
}





















