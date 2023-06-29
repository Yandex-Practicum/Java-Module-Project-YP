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
        do {
            while (!sc.hasNextDouble()) {
                System.out.println("Это не стоимость!");
                sc.next();
            }
            bufCost = sc.nextDouble();
            if(bufCost<0) {
                System.out.println("Не может быть отрицательная стоимость!");
                }
            } while(bufCost<0);
        }
    }


