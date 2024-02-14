import static java.lang.Math.floor;

import java.util.ArrayList;

public class Calculator {
    double countCheck; // сумма счета
    int per;
    ArrayList<String> spisokProdutcs = new ArrayList<>();
    Calculator(int per) { // конструктор
        this.per = per;
        this.countCheck = 0.0d;
    }
    void sum (double price) {      //считаем общую сумму товаров
        this.countCheck += price;
    }

    void spisok (String products) { // добавляем в коллекцию наименование товаров
        spisokProdutcs.add(products);
    }

    void check (){ // печатает чек (товар и сумму)
        Rubls rubls = new Rubls();
        for (String name : spisokProdutcs) {
            System.out.println(name);
        }
        System.out.println(String.format("Сумма для каждого %f.2f %s", floor(countCheck), rubls.Rus(countCheck)));
    }
}
