
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("На сколько человек нужно поделить счет?");
        Scanner in = new Scanner(System.in);
        int countPersons;
        countPersons = in.nextInt();
        while (countPersons <= 1) { // Условие работы цикла - пока значение <= 1
            System.out.println("Неверное значение! Введите количество человек снова!");
            countPersons = in.nextInt();
        }
        Caltulator calc = new Caltulator();
        calc.getDish(countPersons);
    }
}