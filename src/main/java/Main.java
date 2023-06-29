import static java.lang.Math.floor;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String[] tovar = new String[100];        //массив сохранения наименований товара

    static String buf;                              //буфер проверки ввода да - нет
    static int i=0, N=0;                                 //i - счетчик товара, N - кол.человек
    static double[] cost = new double[100];         // массив цен

    public static void main(String[] args) {

        System.out.println("На сколько человек разделить счет?");

            do {
                System.out.println("Введите число больше 1");
                while (!scanner.hasNextInt()) {
                    System.out.println("Это не целое число!");
                    scanner.next();
                }
                N = scanner.nextInt();
            } while (N<=1);

        for (; ; ) {
            Tovar.inputTovar();
            tovar[i] = Tovar.nameTovar;
            Tovar.inputCost();
            cost[i] = Tovar.bufCost;
            i++;
            System.out.println("Товар успешно введен");

            System.out.println("Желаете продолжить ввод товара? " + "Завершено - нет " + "любая буква - да ");
            buf = scanner.next();
            if (buf.equalsIgnoreCase("завершено")) {
                endProgram();
                break;
            }
        }
    }

    private static void endProgram() {
        scanner.close();
        System.out.println("Добавлены товары:");
        for (int j = 0; j < i; j++) {
            System.out.println(tovar[j]);
        }
        double result = 0;
        for (int j = 0; j < i; j++) {
            result = result + cost[j];
        }
        result = result / N;

        System.out.print("Каждый человек должен заплатить - ");

        int x = (int)floor(result);
        int lastX=x%10;
        double i = result-x;
        int cop = (int)floor(i*100);

        if (lastX==1) {
            System.out.println(x + " рубль " + cop + " коп.");
        }
        if(lastX>1 && lastX<5) {
            System.out.printf(x + " рубля " + cop + " коп.");
        }
        if(lastX>4){
            System.out.print(x + " рублей " + cop +" коп.");
        }
    }
}



