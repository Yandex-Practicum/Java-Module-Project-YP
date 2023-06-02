import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;


public class Stuff {


    Scanner scanner = new Scanner(System.in);


    public static String name(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }




    public static double priceStuf(String name){
        Scanner scanner = new Scanner(System.in);
        String keyWOrd1 = "завершить";
        Double price = null;


        if (name.equalsIgnoreCase(keyWOrd1)) {
            return 0;
        } else {
            while(!scanner.hasNextDouble()){
                System.out.println("Допустимы только цифры, попробуйте еще раз");
                scanner.next();
            }
            price = scanner.nextDouble();

            System.out.println("Добавлено успешно");
            System.out.println("Что нибудь еще?");
            }



        return price;

    }

}

