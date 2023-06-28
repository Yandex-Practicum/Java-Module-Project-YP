import static java.lang.Math.floor;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String[] tovar = new String[100];        //массив сохранения наименований товара

    static String buf;                              //буфер проверки ввода да - нет
    static int i,N;                                 //i - счетчик товара, N - кол.человек
    static double[] cost = new double[100];         // массив цен

    public static void main(String[] args) {

        System.out.println("На сколько человек разделить счет?");
        System.out.println("Введите число больше 1");
        N = 0;
        while (N <= 1) {
            N = scanner.nextInt();
            if (N <= 1) {
                System.out.println("Ошибка! Введите число больше 1");
            }
        }

        i = 0;
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

        public static void endProgram(){
                scanner.close();
                for (int j = 0; j < i; j++) {
                    System.out.println("Добавлен товар: " + tovar[j]);
                }
                double result = 0;
                for (int j = 0; j < i; j++) {
                    result = result + cost[j];
                }
                result = result / N;
                String text = "Каждый человек должен заплатить - %.2f";
                System.out.printf(text, result);
                if (floor(result) == 1) {
                    System.out.println(" рубль.");
                }
                else {
                    System.out.println(" рублей.");
                }
            }
        }



