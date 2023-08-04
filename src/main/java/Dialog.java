import java.util.ArrayList;
import java.util.Scanner;
public class Dialog {
    void greetings(){
        System.out.println("Калькулятор снова в деле!");
    }
    void sayBye(){
        System.out.println("Благодарю за выбор нашего калькулятора!");
    }
    int getCount(){// обрабатывает не логичные числа
        int partnersCount;
        partnersCount=this.getInt();
        if (partnersCount<=1){
            System.out.println("Хмм... Делить можно когда участников больше одного.");
            partnersCount=this.getInt();
        }
        System.out.println(partnersCount + " - Прекрасное число!");
        return partnersCount;
    }
    private int getInt(){ //обрабатывает не целоЦифирьный ввод
        Scanner scan=new Scanner(System.in);
        int partnersCount;
        System.out.println("На сколько участников делим?");
        try {
            partnersCount=scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Просто цифрой, пожалуйста");
            partnersCount=this.getInt();
        }
        return partnersCount;
    }
    void getGoods(ArrayList<Goods> lnkBill){//хапАет ссылку, проверяет "Завершить", добавляет корректный ввод
        Scanner scan=new Scanner(System.in);
        String str;
        while (true){
            System.out.println("Введите наименование товара (<Завершить> для подсчета)");
            str = scan.nextLine();
            if (str.equalsIgnoreCase("Завершить")){
                break;
            }
            lnkBill.add(new Goods(str,this.getPrice()));
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
