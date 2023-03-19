
import java.util.Scanner;
public class Calculator {
    String itemNameList = "";
    int numItems;
    float price;

//    public static int enterIsNum() {
//        Scanner scanWord = new Scanner(System.in);
//        int number = scanWord.nextInt();
//        scanWord.nextLine();
//        while (!scanWord.hasNextInt()) {
//            //number = scanner.nextInt();
//            //scanner.nextLine();
//            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
//        }
//        return number;
//
//    }

    // Обработка слова Рубль и вывод на печать
    public static void moneyUnitformat (float Munit) {
        String money = "";
        //String totalSum = "Общая сумма товаров: %.2f";
        if (Munit == 1) {
            money = "%.2f рубль";
            System.out.println(String.format(money, Munit));
        } else if (Munit > 1 && Munit < 5) {
            money = "%.2f рубля";
            System.out.println(String.format(money, Munit));
        } else {
            money = "%.2f рублей";
            System.out.println(String.format(money, Munit));
        }

    }


    Calculator (String itemNameList, float price, int numItems ) {
        this.itemNameList = itemNameList;
        this.price = price;
        this.numItems = numItems;
    }

}
