
import java.util.Scanner;

public class Main {

    public static Scanner scannerPeople = new Scanner(System.in);
    public static void main(String[] args) {

        // Узнаем количество человек для расчета
        System.out.println("На сколько человек необходимо разделить счет?");
        // Цикл проверки на ввод целого числа
        do {
            while (!scannerPeople.hasNextInt()) {
                System.out.println("Некорректный ввод, введите целое число");
                scannerPeople.next();
            }
            PeopleNumber.sumOfPeople();

        } while (scannerPeople.hasNextInt());

    }

}