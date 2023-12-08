import java.util.Scanner;

public class allRub {
    public static void allRub(double account) {
        Scanner scanner = new Scanner(System.in);
        if (account % 100 >= 11 && account % 100 <= 14) {
            System.out.println(account + " рублей");
            return;
        } else if (account % 10 == 1) {
            System.out.println(account + " рубль");
            return;
        } else if (account % 10 == 2 || account % 10 == 3 || account % 10 == 4) {
            System.out.println(account + " рубля");
            return;
        } else {
            System.out.println(account + " рублей");
            return;

        }
    }
}
