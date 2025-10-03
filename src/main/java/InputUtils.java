import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtils {
    private final Scanner scanner = new Scanner(System.in);
    private final Pattern carNameValidationPattern = Pattern.compile("^[a-zA-Za-яА-Я0-9\\s]+$");

    final int MIN_SPEED = 0;
    final int MAX_SPEED = 250;

    public String requestAutoName(int autoNumber) {
        String input;
        boolean isValid;
        do {
            System.out.println("Введите имя автомобиля " + autoNumber + ". Русские и английские буквы и цифры:");
            input = scanner.nextLine();
            isValid = !input.isEmpty() && carNameValidationPattern.matcher(input).matches();

            if (!isValid) {
                System.out.println("Ввод содержит недопустимые символы. Введите название машины заново");
            }
        } while (!isValid);
        return input;
    }

    public int requestAutoSpeed() {
        System.out.println("Введите скорость. Целое число в пределах от 0 до 250: ");
        String number = scanner.nextLine().trim();

        try {
            int result = Integer.parseInt(number);
            if (validateSpeed(result)) {
                return result;
            }
        } catch (Exception e) {
            String message;
            if (e instanceof NumberFormatException) {
                message = "Введенное значение не является числом";
            } else {
                message = e.getMessage();
            }
            System.out.println(message);
            requestAutoSpeed();
        }
        return 0;
    }

    private boolean validateSpeed(int speed) {
        if (speed > MIN_SPEED && speed <= MAX_SPEED) {
            return true;
        } else {
            throw new IncorrectSpeedException();
        }
    }

    static class IncorrectSpeedException extends IllegalArgumentException {
        public IncorrectSpeedException() {
            super("Скорость вне корректных значений");
        }
    }
}
