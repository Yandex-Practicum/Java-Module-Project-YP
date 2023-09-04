import java.util.Scanner;

class UserInputs {
    Scanner scanner = new Scanner(System.in);

    public class StringInput {
        public String in() {
            String value;

            while (true) {
                value = scanner.next();

                if (value.matches("[a-zA-Zа-яА-Я]*")) {
                    break;
                } else {
                    System.out.println("Не корректный ввод, должно быть строковое значение.");
                    System.out.print("Повторите ввод: ");
                }
            }

            return value;
        }
    }

    public class FloatInput {
        public float in() {
            float value = 0;
            boolean isCorrect = false;

            while (isCorrect == false) {
                if (scanner.hasNextFloat()) {
                    value = scanner.nextFloat();

                    if (value > 0) isCorrect = true;
                } else {
                    scanner.next();
                }

                if (isCorrect == false) {
                    System.out.println("Не корректный ввод, должно быть дробное и положительное число.");
                    System.out.print("Повторите ввод: ");
                }
            }

            return (float)value;
        }
    }

    public class IntInput {
        public int in() {
            int value = 0;
            boolean isCorrect = false;

            while (isCorrect == false) {
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt();

                    if (value > 0) isCorrect = true;
                } else {
                    scanner.next();
                }

                if (isCorrect == false) {
                    System.out.println("Не корректный ввод, должно быть целое и положительное число.");
                    System.out.print("Повторите ввод: ");
                }
            }

            return (int)value;
        }
    }
}
