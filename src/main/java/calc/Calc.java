package calc;

import java.util.ArrayList;

public class Calc {      //Класс финишного расчета
    //int i;
    int numberOfLine;           //количество строк в счете
    int man;                    //Количество человек
    double temp;                //временная переменная для расчета
    float foreOneMan;           // Величина счета на каждого
    float summ=0 ;              // сумма по всем строкам счета
    calc.Check check;
    ArrayList<calc.Check> listCheck;



    //Конструктор принимает массив пунктов меню, количество строк в счете, и количество персон
    Calc (ArrayList <calc.Check> listCheck, int numberOfLine, int man) {
        this.listCheck = listCheck;
        this.numberOfLine=numberOfLine;
        this.man=man;
    }


    void printing() {                              // Печать всех строчек счета по итогу работы
        int i;
        for (i = 0; i < numberOfLine; i++) {
            check = listCheck.get(i);
            System.out.println("№ " + check.i + "- " + check.point + ", по цене " + String.format("%.2f",check.price)
                    + " " + Main.rub(check.price) + " в количестве " + check.kol + " шт.");
        }
    }





    void calculation(){                             //Финишный расчет всех строк счета
        //System.out.println("зашел в калк" + +numberOfLine);
        int i;
        for (i=0;i<numberOfLine;i++) {
            check = listCheck.get(i);              //Получаю след строчку
            summ = summ + check.price * check.kol; //Суммирую все Цены всех  пунктов меню
        }

        temp = summ / man;                                           // Математическое округления до целых копеек
        temp = 0.01 * Math.round(temp * 100);
        foreOneMan = (float) temp;                              //Фиксация текущей величины с человека округленная до копеек
    }
}