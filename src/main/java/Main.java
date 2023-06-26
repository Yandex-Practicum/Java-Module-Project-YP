
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\t\tКАЛЬКУЛЯТОР СЧЁТА\n");
        new Calculator(getSumPeople());

        System.exit(0);
    }

    private static int getSumPeople() {
        Scanner scanner = new Scanner(System.in);
        int numb;
        String strIn;

        System.out.println("На скольких человек необходимо разделить счёт? Введите число: ");

        while (true) {
            strIn = scanner.nextLine();

            if (strIn.matches("^[0-9]+$")) {
                numb = Integer.parseInt(strIn.trim());
                    if (numb <= 1)
                        System.out.println(numb + " - некорректное значение. Введите количество человек:");
                    else
                        return numb;
            } else
                System.out.println("Неизвестный символ. Введите число:");
        }
    }

}