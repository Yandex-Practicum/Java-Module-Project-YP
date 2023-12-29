import java.util.Scanner;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    public double verifyDouble() {
        boolean verifyDouble = false;
        double res = 0;

        while (!verifyDouble) {
            if (scanner.hasNextDouble()) {
                double tmp = scanner.nextDouble();
                scanner.nextLine();
                if (tmp > 0) {
                    res = tmp;
                    verifyDouble = true;
                } else {
                    System.out.println("Стоимость не может быть меньше 0");

                }
            } else {
                System.out.println("Не тот формат ввода. Повторите");
                scanner.nextLine();
            }
        }
        return res;
    }

    public int verifyInt() {
        boolean verify = false;
        int res = 0;

        while (!verify) {
            if (!scanner.useDelimiter("\n").hasNextInt()) {
                System.out.println("Не тот формат ввода. Введите целое число");
                scanner.nextLine();
            } else {
                int tmp = scanner.useDelimiter("\n").nextInt();
                scanner.nextLine();
                if (tmp < 2) {
                    System.out.println("Значение должно быть больше или равно 2");
                } else {
                    res = tmp;
                    verify = true;
                }
            }
        }
        return res;
    }

    public String verifyString() {
        boolean verify = false;
        String res = "";

        while (!verify) {
            String tmp = scanner.nextLine().trim();
            if (tmp.isEmpty()) {
                System.out.println("Наименование не может быть пустым");

            } else {
                verify = true;
                res = tmp;
            }

        }
        return res;
    }
}
