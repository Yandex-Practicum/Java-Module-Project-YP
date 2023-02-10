import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> items;
        ArrayList<Double> price;
        int humans;
        int amount;
        double sum;
        try (Scanner scanner = new Scanner(System.in)) {
            items = new ArrayList<String>();
            price = new ArrayList<Double>();
            double d;
            String s = "Что-то";
            amount = 0;
            sum = 0.0;
            System.out.println("На скольких человек необходимо разделить счёт?");
            humans = scanner.nextInt();
            while (humans <= 1) {
                if (humans == 1) {
                    System.out.println("Количество человек, введённых пользователем, равно 1. В этом случае нет смысла ничего считать и делить.");
                } else {
                    System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
                }
                System.out.println("Введите значение заново?");
                humans = scanner.nextInt();
            }
            while (!(s.equals("Завершить"))) {
                scanner.nextLine();
                System.out.println("Введите название продукта.");
                s = scanner.nextLine();
                items.add(s);
                if((s.equals("Завершить"))){
                    break;
                }
                System.out.println("Введите цену продукта");
                d = scanner.nextDouble();
                price.add(d);
                amount++;
                System.out.println("Введите 'Завершить', если вы хотите произвести расчёт");
            }
        }
        System.out.println();
        for (int i=0; i<amount;i++){
            System.out.println(items.get(i));
            System.out.println("Цена: "+price.get(i)+" рублей");
            sum = Double.sum(sum, (Double) price.get(i));
        }
        System.out.println();
        System.out.println("Сумма: "+sum+" рублей");
        System.out.println();
        System.out.println("На одного человека: "+(sum/humans)+" рублей");
    }
}
