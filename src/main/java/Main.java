import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int i;
        int ru;
        float cost;
        //float sum=0;
        double temp;
        int kolvo;
        int chel;
        String schet="";
        String name = "";
        //String ru="";

        //Запрос  количества персон?");

        Scanner scanner = new Scanner(System.in);

        while  (true) {
            System.out.println("Какое количество персон?");
            if (scanner.hasNextInt()) {
                chel=scanner.nextInt();
                if (chel<1) {System.out.println("Cлишком мало гостей");}
                else if(chel==1) {System.out.println("Платить придется самому, или уточните ");}
                else {System.out.println("счет будет разделен на " + chel); break;}
            }
            else if (scanner.hasNextFloat()) {System.out.println("Все гости должны быть целыми");scanner.next();}
            else {System.out.println("ВВедите численное значение");scanner.next();}
        }
        // Формирование строкового списка заказа и отправка на расчет
        i=0;
        Calc calc= new Calc(chel,0,0,"");
        while (true) {
            i++;
            System.out.println("ВВедите наименование блюда или \"Завершить\"");
            //scanner  = new Scanner(System.in);
            name = scanner.next();
            scanner.nextLine();
            if (name.equalsIgnoreCase("Завершить")) {
                System.out.println(name);
                break;}

            //System.out.println("ВВедите Цену блюда");
            while (true) {// Мучать пока не введут число
                System.out.println("ВВедите Цену блюда");
                if (scanner.hasNextFloat()) {
                    cost = scanner.nextFloat();
                    //

                    temp = 0.01 * Math.round(cost * 100); //Отсекаем математическим округлением все что дальше копеек
                    //System.out.println(temp);
                    cost = (float) temp;

                    break;}
                else {scanner.next();}

            }

            while (true) {// Мучать пока не введут целое число
                System.out.println("ВВедите количество одинаковых блюд");
                if (scanner.hasNextInt()) {
                    kolvo = scanner.nextInt();
                    break;}
                else {scanner.next();}

            }
            //System.out.println("ВВедите количество одинаковых блюд");
            //kolvo  = scanner.nextInt();

            // sum=sum+cost*kolvo; //Без классовый механизм расчета суммы

            //Формирование строки
            schet= schet + "Пункт меню № "+i+ "-- " +name + ", по цене "+ cost+ " в количестве "+kolvo+" шт."+"\n";
            calc.add(cost,kolvo);//Отправляем очередную строчку на просчет.
            calc.point= calc.point+" * "+name; // Добавляем в атрибут наименования пункта меню еще одно наименование блюда символом разделителем
            System.out.println ("Добавлен Пункт меню № "+i+ "- " +name + ", по цене "+ cost+" "+rub(cost)+" в количестве "+kolvo+" шт.");

            calc.sRila=sverka (calc.chel,calc.summ,calc.sRila); //Уточнение расчета до копеечки

            //System.out.println(calc.sRila);

        }
        System.out.println("Итого");
        System.out.println("Добавленные товары:");
        System.out.println(schet );
        System.out.println("Общая сумма по счету"+String.format("%.2f",calc.summ));
        System.out.print("С каждого по "+String.format("%.2f",calc.sRila ));
        //ru= (int) (Math.floor(calc.sRila)-10*Math.floor(calc.sRila/10)); //выясняем численный крайний рубль
        System.out.println(" "+rub(calc.sRila));
        // вывод информации какая сумма с Человека
        if (calc.summ!= (calc.sRila* calc.chel)) {System.out.println("И на чай оставим "+String.format("%.2f",(calc.sRila* calc.chel-calc.summ) ));}


        scanner.close();//Закрываем Scanner по завершении работы.
        //k=0;
        // while (k<i) {
        //   i++;
        //  System.out.println("Вывод" + schet);

        // }
        //public static float sverka(int a,float b,float c) {
        //    System.out.println("Пойду-ка сделаю себе кофе")
        //}






    }

    private static float sverka(int chel, float summ, float sRila) {
        while (summ>chel*sRila) { sRila= (float) (sRila+0.01);}

        return sRila;
    }
    private static String rub(float r) { //Выбор окончания
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
    public static class Calc {

        //int i;
        int chel;//количество персон
        int kol;// кол-во одинаковых блюд
        String point;//наименование пункта меню
        float price;//Цена пункта меню
        double t=0;
        float sRila=0;
        float summ=0 ;
        ///Calc(int n, String point, float price, int kol) {
        Calc( int che,float pri, int k,String poi) {
            chel = che; //наименование пункта меню
            price = pri; //Цена пункта меню
            kol = k; // кол-во одинаковых блюд
            point=poi;//Название пункта менею
        }
        void add(float price, int kol){
            summ= summ+price*kol; //Цена пункта меню
            t=summ/chel;  // Такое же мат округление
            t = 0.01 * Math.round(t * 100);
            sRila=(float) t;  //Фиксация текущей величины сброса
            // this kol = kol;
        }
    }
}