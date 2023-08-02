
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Caltulator calc = new Caltulator();
        calc.getDish(getPersons());
    }
    public static int getPersons() {
        System.out.println("На сколько человек нужно поделить счет?");
        Scanner in = new Scanner(System.in);
        int countPersons;
        while (!in.hasNextInt()) {
            System.out.println("Ошибочка!");
            System.out.println("Введите повторно");
            in.next();
        }
        countPersons = in.nextInt();
        while (countPersons <= 1) { // Условие работы цикла - пока значение <= 1
            System.out.println("Неверное значение! Введите количество человек снова!");
            countPersons = in.nextInt();
        }
        return countPersons;
    }
}