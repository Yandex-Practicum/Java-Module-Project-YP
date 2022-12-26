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
        
        /* Этот комментарий, чтобы показать Pull Request между двумя ветками моего репозитория main и dev. */ 
        /* Сам код уже написан, но при первом ревью я создал Pull Request между моим репозиторием и репозиторием Yandex-Practicum. */
    }
}
