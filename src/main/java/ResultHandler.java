import java.util.ArrayList;

public class ResultHandler {

    public void showResult (ArrayList<Product> products , double priceForOne) {
        if (priceForOne != 0) {
            System.out.println("Добавленные товары:");
            for (Product k : products) {
                System.out.println("-" + k.name);
            }
            String rubName = getRubName(priceForOne);
            String format = "Каждый человек должен заплатить: %.2f %s.";
            System.out.println(String.format(format, priceForOne, rubName));
        } else {
            System.out.println("Нет добавленных товаров");
            System.out.println("Счёта на оплату нет");
        }
    }
    public static String getRubName(double price) {
        int preLastDigit = (int)price % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }
        switch ((int)price % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
