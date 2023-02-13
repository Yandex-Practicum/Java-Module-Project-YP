import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> items;
        ArrayList<Double> price;
        int humans=-1;
        int amount=0;
        double sum2=0.0;
        boolean bPrice = false;
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        items = new ArrayList<String>();
        price = new ArrayList<Double>();
        double d=0.0;
        String s = "Что-то";
        amount = 0;
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (humans <= 1) {
            try{
                humans = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Вы не ввели целое положительное число.");
                scanner.next();
                bPrice=true;
            }
            if ((humans == 1)&&!(bPrice)) {
                System.out.println("Количество человек, введённых пользователем, равно 1. В этом случае нет смысла ничего считать и делить.");
            } else if((humans <= 1)&&!(bPrice)){
                System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            }
            bPrice=false;
        }
        scanner.nextLine();
        while (true) {
            System.out.println("Введите название продукта.");
            s = scanner.nextLine();
            items.add(s);
            if((s.equalsIgnoreCase("Завершить"))){
                break;
            }
            System.out.println("Введите цену продукта.");
            while (!(bPrice)){
                try{
                    d = scanner.nextDouble();
                    bPrice=true;
                } catch (InputMismatchException ex) {
                    System.out.println("Вы не ввели численное значение.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            bPrice=false;
            price.add(d);
            amount++;
            System.out.println("Введите 'Завершить', если вы хотите произвести расчёт");
            }
        scanner.close();
        System.out.println();
        sum2=calculator.sum(amount, price, items);
        calculator.finalCalcutation(sum2,humans);
    }
}
class Calculator{
    int round;
    double am;

    double sum(int amount, ArrayList<Double> price, ArrayList<String> items){
        double sum = 0.0;
        for (int i=0; i<amount;i++){
            System.out.println(items.get(i));
            am = price.get(i);
            rU(am);
            System.out.println("Цена: "+price.get(i)+rU(am));
            sum = Double.sum(sum, (Double) price.get(i));
        }
        return sum;
    }

    void finalCalcutation(double yeah, int humans){
        System.out.println("Сумма: "+yeah+rU(yeah));
        System.out.println();
        System.out.println("На одного человека: "+(yeah/humans)+rU(yeah/humans));
    }
    String rU(double eternal){
        this.round=(int) eternal;
        if(this.round%100==11||this.round%100==12||this.round%100==13||this.round%100==14||this.round%100==15||this.round%100==16||this.round%100==17||this.round%100==18||this.round%100==19){
            return" рублей";
        }else{
            if(round%10==1){
                return " рубль";
            }else if(round%10==2||round%10==3||round%10==4){
                return " рубля";
            }else{
                return " рублей";
            }
        }
    }
}