
import java.util.Scanner;
public class Calculator {

    String itemNameList = "";
    int numItems;
    float price;


    // Обработка слова Рубль и вывод на печать
    public static void moneyUnitformat (float Munit) {
        String money = "";
        //String totalSum = "Общая сумма товаров: %.2f";

        int iMunit = (int)Munit;
        int mCh = iMunit%10;

        if (iMunit%100>=11 && iMunit<=14) {
            money = "%.2f рублей";
            System.out.println(String.format(money, Munit));
        } else {
            switch (mCh) {
                case 1:
                    money = "%.2f рубль";
                    System.out.println(String.format(money, Munit));
                    break;
                case 2:
                case 3:
                case 4:
                    money = "%.2f рубля";
                    System.out.println(String.format(money, Munit));
                    break;
                default:
                    money = "%.2f рублей";
                    System.out.println(String.format(money, Munit));
            }
        }
    }



//    public static void checkInt() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            if (!scanner.hasNextInt()) {
//                //number = scanner.nextInt();
//                //scanner.nextLine();
//                System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
//                scanner.nextLine();}
//            else break;
//        }
//    }


    Calculator (String itemNameList, float price, int numItems ) {
        this.itemNameList = itemNameList;
        this.price = price;
        this.numItems = numItems;
    }

}
