import static modules.Modules.getAddProductsFromUser;
import static modules.Modules.getCountPeople;
import static modules.Modules.makeResult;

import java.util.ArrayList;

import entity.Products;

public class Main {

    public static void main(String[] args) {
        /* Начало */
        /* Вводим количество гостей */
        int countPeople = getCountPeople();

        /* Создаем список товаров для калькулятора */
        ArrayList<Products> products = getAddProductsFromUser();

        /* Распаковка результата */
        makeResult(products, countPeople);
    }
}
