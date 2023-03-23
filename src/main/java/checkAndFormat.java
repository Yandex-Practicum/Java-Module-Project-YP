import java.util.Scanner;

public class checkAndFormat {


    // Обработка слова Рубль и вывод на печать
    public static void moneyUnitformat(float Munit) {
        String money = "";
        //String totalSum = "Общая сумма товаров: %.2f";

        int iMunit = (int) Munit;
        int mCh = iMunit % 10;

        if (iMunit % 100 >= 11 && iMunit <= 14) {
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

    // функция проверки корректности ввода количества человек и далее вывода в main
    public static int checkPersonVal() {
        Scanner scanner = new Scanner(System.in);
        int numPerson;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Извините, но это явно не число. Введите число и попробуйте снова!");
                scanner.nextLine();
            } else {
                numPerson = scanner.nextInt();
                scanner.nextLine();
                if (numPerson >= 1) {
                    break;}
                else {System.out.println("Значение не подходит, введите другое значение");
                    scanner.nextLine();}
            }
        }
        return numPerson;
    }


    // функция проверки корректности ввода цены товара и далее вывода в main
    public static float checkItemVal() {
        Scanner scanner = new Scanner(System.in);
        float Item;
        while (true) {
            if (!scanner.hasNextFloat()) {
                System.out.println("Извините, но это явно не число. Введите число и попробуйте снова!");
                scanner.nextLine();
            }else{
            Item = scanner.nextFloat();
            scanner.nextLine(); // специфичный метод для завершения ввода...
            if (Item > 0) {
                break;}
            else {System.out.println("Значение не подходит, введите другое значение");
                scanner.nextLine();;}
        }
    }
        return Item;
    }

}
