import static modules.Modules.getAddProductsFromUser;
import static modules.Modules.getCountPeople;

import java.util.ArrayList;

import entity.Products;

public class Main {

    public static void main(String[] args) {
        /* Начало */
        /* Вводим количество гостей */
        int countPeople = getCountPeople();
        //System.out.println(" Значение переменной countPeople = " + countPeople);
        /* Создаем список товаров для калькулятора */
        ArrayList<Products> products = getAddProductsFromUser();
        for (Products prod: products) {
            System.out.println(prod + " \n ");
        }
        System.out.println(" size = " + products.size());


    }
}
