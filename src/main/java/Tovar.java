import java.util.Scanner;

public class Tovar {

    static Scanner sc = new Scanner(System.in);
    static String nameTovar;
    static double bufCost;
    public static void inputTovar() {

        System.out.println("Введите название товара ");
        nameTovar = sc.next();
    }

    public static void inputCost() {
        System.out.println("Введите стоимость товара ");
        if (sc.hasNextDouble()) {
            bufCost = sc.nextDouble();
        } else {
            System.out.println("Это не число");
        }
    }
}

