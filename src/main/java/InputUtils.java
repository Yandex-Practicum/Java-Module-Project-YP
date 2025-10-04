import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtils {
    private final Pattern carNameValidationPattern = Pattern.compile("^[a-zA-Za-яА-Я0-9\\s]+$");

    final int MIN_SPEED = 0;
    final int MAX_SPEED = 250;

    public String requestAutoName(int autoNumber) {
        String input;
        boolean isValid;
        do {
            Scanner scanner = new Scanner(System.in);
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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите скорость. Целое число в пределах от 0 до 250:");
            String input = scanner.nextLine().trim();
            int speed;
            if (input.matches("^-?[1-9]\\d{0,8}|(0)$")) {
                speed = Integer.parseInt(input);
            } else {
                System.out.println("Введенное значение не является числом или вне рамок типа int");
                continue;
            }
            if (isSpeedIsValid(speed)) {
                return speed;
            } else {
                System.out.println("Введенное значение не соответствует критериям");
            }
        }
    }

    private boolean isSpeedIsValid(int speed) {
        return (speed > MIN_SPEED && speed <= MAX_SPEED);
    }
}
