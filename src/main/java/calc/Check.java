package calc;

public class Check {    // Класс пункта одной строки счета указаны Номер по порядку, наименование , цена, количество

    int i;
    int kol;// кол-во одинаковых блюд
    String point;//наименование пункта меню
    float price;//Цена пункта меню

    Check(int i, String point,float price, int kol) {
        this.i=i;
        this.point=point;
        this.price = price;        //Цена пункта меню
        this.kol = kol;            // кол-во одинаковых блюд
        //this.point=point;          //Название пункта менею
    }


    void print() {               //Печать очередного добавленного пункта меню
        System.out.println("Добавлен Пункт меню № " + i + "- " + point + ", по цене "
                + String.format("%.2f",price) + " " + Main.rub(price) + " в количестве " + kol + " шт.");
    }
}
