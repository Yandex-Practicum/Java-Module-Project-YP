/*
         Класс корзина предназначен для сохранения введенных товаров,
        а также суммирования их цен,
        для последующего деления на колличество человек.
*/
import java.util.ArrayList;

public class Basket {
    double sum = 0.00;
    ArrayList<String> list = new ArrayList<String>();

    //метод добавления введенных продуктов
    public void addProduct(String product, double price){

        list.add(product);
        System.out.println("Товар добавлен в корзину.");
        sum +=price;

    }

    // Метод для изменения падежа рубля.
    public String convertRub (float sum){

        String rub = "рублей";
        int preSum =(int) sum % 100;
        int lastsum = (int) sum % 10;

        if(preSum > 10 && preSum <20)
            rub ="рублей";
        else if(lastsum >1 && lastsum < 5)
            rub ="рубля";
        else if(lastsum == 1)
            rub ="рубль";
        else
            rub ="рублей";

        return rub;
    }
}
