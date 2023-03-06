import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {

        String peekingEye = "\uD83E\uDEE3"; // Имеет ли смысл записывать их как константы?
        String thinkingFace = "\uD83E\uDD14";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Надеюсь, что Вы вкусно покушали! " +
                "Введите количество человек на которых нужно разделить чек.");

        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Целое число, пожалуйста!" + peekingEye);
                scanner.nextLine();
            } else {

                int numberOfPersons = scanner.nextInt();

                if (numberOfPersons == 1) {
                    System.out.println("Кажется, что Вы ели в одиночестве " + thinkingFace +
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
