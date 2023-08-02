import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int partnersCount;
       Dialog dial=new Dialog();
       ArrayList <Goods> bill = new ArrayList<>();// позиции в счете - динамика

       dial.greetings();
       partnersCount= dial.getCount();
       dial.getGoods(bill);
       dial.showList(bill);
       dial.showHowMuchToPay(partnersCount,bill);
       dial.sayBye();
    }
    public static class Goods {// Описывает позицию в счете
            String name="__";
            double price=0;
        public Goods(){}; // для обработки создания без параметров ***УДАЛИТЬ?***
            public Goods(String name_, double price_) {
                name =name_ ;
                price=price_;
            }

    }
    public static class Dialog{

        void greetings(){
            System.out.println("Калькулятор снова в деле!");
        }
        void sayBye(){
            System.out.println("Благодарю за выбор нашего калькулятора!");
        }
        int getCount(){// обрабатывает не логичные числа
            int i;
            i=this.getInt();
            if (i<=1){
                System.out.println("Хмм... Делить можно когда участников больше одного.");
                i=this.getInt();
            }
            System.out.println(i + " - Прекрасное число!");
            return i;
        }
        private int getInt(){ //обрабатывает не целоЦифирьный ввод
            Scanner scan=new Scanner(System.in);
            int i;
            System.out.println("На сколько участников делим?");
            try {
                i=scan.nextInt();
            }
            catch (Exception e){
                System.out.println("Просто цифрой, пожалуйста");
                i=this.getInt();
            }
            return i;
        }
        void getGoods(ArrayList <Goods> lnkBill){//хапАет ссылку, проверяет "Завершить", добавляет корректный ввод
            Scanner scan=new Scanner(System.in);
            String str;
            while (true){
                System.out.println("Введите наименование товара (<Завершить> для подсчета)");
                str = scan.nextLine();
                if (str.equalsIgnoreCase("Завершить")){
                    break;
                }
                lnkBill.add(new Goods (str,this.getPrice()));
            }

        }
        private double getPrice(){
            Scanner scan=new Scanner(System.in);
            double dPrice;
            System.out.println("Пожалуйста, введите цену");
                if (scan.hasNextDouble()) {
                    dPrice = scan.nextDouble();
                    if (dPrice < 0) {
                        System.out.println("Эхх, таких цен нет.");
                        dPrice = this.getPrice();
                    }
                }
                else {
                    System.out.println("Ой, это не цена!");
                    dPrice=this.getPrice();
                }
            return dPrice;
        }
        void showList(ArrayList <Goods> lnkBill){
            double total=0;
            Calcula calc=new Calcula();
            System.out.println("Всего " + lnkBill.size()+" ед.:");
            for (int i=0;i<lnkBill.size();i++){
                System.out.print(lnkBill.get(i).name+": ");
                System.out.println(lnkBill.get(i).price);
                total+= lnkBill.get(i).price;
            }
            System.out.format("На общую сумму %.2f "+ calc.doubleToRuble(total)+".\n",total);
        }
    void showHowMuchToPay(int partnersCount_, ArrayList <Goods> lnkBill) {
        Calcula calc = new Calcula();
        double total = 0;

            for (int i = 0; i < lnkBill.size(); i++) {
            total += lnkBill.get(i).price;
        }
            total=total/partnersCount_;
            System.out.format("К оплате по %.2f "+ calc.doubleToRuble(total)+" с каждого.\n",total);
}
    }
    public static class Calcula{
        public String doubleToRuble (double price_){ // именует рубли
            String str;
            double d=Math.floor(price_);
            if (d==11 || d==12|| d==13|| d==14) {
                return  "рублей";
            }
            switch ((int)d %10) {
                case 1:
                    str = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    str = "рубля";
                    break;
                default:
                    str = "рублей";

            }
            return str;
        }
    }
}