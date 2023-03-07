import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {
    static final String PEEKING_EYE = "\uD83E\uDEE3";
    static final String THINKING_FACE = "\uD83E\uDD14";

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Привет! Надеюсь, что Вы вкусно покушали! " +
                "Введите количество человек на которых нужно разделить чек.");

        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Целое число, пожалуйста!" + PEEKING_EYE);
                scanner.nextLine();
            } else {

                int numberOfPersons = scanner.nextInt();

                if (numberOfPersons == 1) {
                    System.out.println("Кажется, что Вы ели в одиночестве " + THINKING_FACE +
                            " или опечатались.\n" + "Попробуем снова?");
                } else if (numberOfPersons < 1) {
                    System.out.println("Ooopss, ошибочка вышла! Попробуем снова!");
                } else {
                    System.out.println("Отлично, значит будем делить счет на " + numberOfPersons + " человек!");
                    Menu.foodList(numberOfPersons);
                    break;
                }
            }
        }
    }
}
