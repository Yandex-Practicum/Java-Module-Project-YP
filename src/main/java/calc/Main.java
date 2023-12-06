package calc;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        int numberOfLine=0;                  //Сумма с каждого
        //int ru;
        float cost;
        double temp;
        int kolvo;
        int man;
        //String schet="";
        String name;

        Scanner scanner = new Scanner(System.in);

       // Запрос и вывод количество персон
        man=person();
        System.out.println("Счет будет разделен на " + man);

        //Создаем динамический массив из переменных класса "Строка заказа"
        ArrayList <Check> listCheck= new ArrayList <>(3);


        while (true) {   //Безконечный цыкл внесения новых строк в счёт
                                        // Запрос очередного наименования блюда
            System.out.println("ВВедите наименование блюда или \"Завершить\"");
            name = scanner.next();
            scanner.nextLine();

            //Проверка на прерывание безконечного цикла
            if (name.equalsIgnoreCase("Завершить")) { break;}

            numberOfLine++;   //Увеличиваем счетчик строк в заказе


            while (true) {// Мучать пока не введут число  //Цыкл по определению цены за одну порцию
                System.out.println("ВВедите Цену блюда");
                if (scanner.hasNextFloat()) {
                    cost = scanner.nextFloat();
                    //

                    temp = 0.01 * Math.round(cost * 100); //Отсекаем математическим округлением все что дальше копеек
                    //System.out.println(temp);
                    cost = (float) temp;

                    break;}
                else {System.out.println("ВВедите ЦЕНУ в формате __,__  ");scanner.next();}

            }

            while (true) {// Мучать пока не введут целое число  //Цикл по определению
                System.out.println("ВВедите количество одинаковых блюд");
                if (scanner.hasNextInt()) {
                    kolvo = scanner.nextInt();
                    break;}
                else {System.out.println("ВВедите ЦЕЛОЕ ЧИСЛЕННОЕ количество одинаковых блюд");
                    scanner.next();}

            }

            Check check = new Check(numberOfLine, name, cost, kolvo); //Создаем переменную класса "Строка заказа" и зполняем ее содержание
            check.print();                      //Отправляем на печать факт Создание очередного объекта строка чека.

            listCheck.add(check);               //Внесение нового объекта в список заказа

          }


        Calc calc= new Calc(listCheck,numberOfLine,man);

        calc.calculation();//ОТПРАВЛЯЕМ НА ИТОГОВЫЙ РАСЧЕТ

        calc.foreOneMan=sverka (calc.man,calc.summ,calc.foreOneMan); //Уточнение расчета до копеечки

        System.out.println("Итого :");

        calc.printing();  //ОТПРАВЛЯЕМ НА ПЕЧАТЬ ВСЮ ТАБЛИЦУ ПУНКТОВ МЕНЮ

        // вывод информации какая сумма с Человека
        System.out.println("Общая сумма по счету"+String.format("%.2f",calc.summ));
        System.out.print("С каждого по "+String.format("%.2f",calc.foreOneMan ));
        System.out.println(" "+rub(calc.foreOneMan));


        // Проверка чаевых
        if (calc.summ!= (calc.foreOneMan* calc.man)) {System.out.println("И на чай оставим "
                +String.format("%.2f",(calc.foreOneMan* calc.man-calc.summ) ));}


        scanner.close();//Закрываем Scanner по завершении работы.


    }

    private static float sverka(int man, float summ, float foreOneMan) {  //Проверка достаточности внесенных средств до копейки
        while (summ>man*foreOneMan) { foreOneMan= (float) (foreOneMan+0.01);}

        return foreOneMan;
    }




    public static String rub (float r) { //Выбор формы слова "Рубль"
        int ru;
        ru= (int) (Math.floor(r)-10*Math.floor(r/10)); //выясняем численный крайний рубль
        switch (ru){
            case 1 : return "рубль.";
            case 2 :
            case 3 :
            case 4 : return "рубля.";
            default :  return "рублeй.";

        }

    }



    private static int person() {                 //Запрос определения количества персон
        int people;
        Scanner scanner = new Scanner(System.in);

        while  (true) {
            System.out.println("Какое количество персон?");
            if (scanner.hasNextInt()) {
                people=scanner.nextInt();
                if (people<1) {System.out.println("Cлишком мало гостей");}
                else if(people==1) {System.out.println("Платить придется самому, или уточните ");}
                else { break;}
            }
            else if (scanner.hasNextFloat()) {System.out.println("Все гости должны быть целыми");scanner.next();}
            else {System.out.println("ВВедите численное значение");scanner.next();}
        }
        return people;
    }

    /*public static class Check {    // Класс пункта одной строки счета указаны Номер по порядку, наименование , цена, количество

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
                    + String.format("%.2f",price) + " " + rub(price) + " в количестве " + kol + " шт.");
       }
    }*/






   /* public static class Calc {      //Класс финишного расчета
        //int i;
        int numberOfLine;           //количество строк в счете
        int man;                    //Количество человек
        double temp;                //временная переменная для расчета
        float foreOneMan;           // Величина счета на каждого
        float summ=0 ;              // сумма по всем строкам счета
        Check check;
        ArrayList <Check> listCheck;



        //Конструктор принимает массив пунктов меню, количество строк в счете, и количество персон
        Calc (ArrayList <Check> listCheck, int numberOfLine, int man) {
            this.listCheck = listCheck;
            this.numberOfLine=numberOfLine;
            this.man=man;
        }


        void printing() {                              // Печать всех строчек счета по итогу работы
            int i;
            for (i = 0; i < numberOfLine; i++) {
                check = listCheck.get(i);
                System.out.println("№ " + check.i + "- " + check.point + ", по цене " + String.format("%.2f",check.price)
                        + " " + rub(check.price) + " в количестве " + check.kol + " шт.");
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
    }*/
}