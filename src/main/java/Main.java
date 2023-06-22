import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Введите число гостей");

        int guests = Integer.parseInt(myObj.nextLine());
        if (guests <= 1) {
            System.out.println("Некореректное число гостей");
            return;
        }
        System.out.println("Введенное количество гостей: " + guests);
        double Goods = 0;

        while (true) {
            System.out.println("Введите название товара: ");
            String itemName = myObj.nextLine();
            System.out.println("Введите стоимость товара: ");
            double itemPrice = Double.parseDouble(myObj.nextLine());
            Goods = Goods + itemPrice;
            if (Goods <= 1) {
                System.out.println("Неверная ценна товара");
                return;
            }
            System.out.println("Добавлен товар " + itemName + "," + itemPrice);
            System.out.println("Хотите ли добавить еще товар?");

            String UserInput = myObj.nextLine();
            System.out.println(UserInput.toLowerCase());
            if (UserInput.toLowerCase().equals("завершить")) {
                break;
            }
        }
        double result = Goods / guests;
        System.out.printf("%.2f %s", result, rubleEnding(result));
    }
    public static String rubleEnding(double amount) {
        int rubles = (int) amount;
        if (rubles % 10 == 1 && rubles % 100 != 11) {
            return "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
