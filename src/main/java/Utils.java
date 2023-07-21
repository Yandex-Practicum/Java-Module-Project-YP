import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntFromTerminal() {
        while(true) {
            try {
                int result = scanner.nextInt();
                return result;
            } catch (InputMismatchException ex) {
                System.out.println("<Вы ввели невалидное целое число. Попробуйте снова.>");
            } catch (Exception ex) {
                System.out.println("<Что-то пошло не так, попробуйте снова.>");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public static double getDoubleFromTerminal() {
        while(true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("<Вы ввели невалидное вещественное число. Попробуйте снова.>");
            } catch (Exception ex) {
                System.out.println("<Что-то пошло не так, попробуйте снова.>");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public static String getStringFromTerminal(boolean allowEmpty) {
        while(true) {
            try {
                String input = scanner.nextLine();
                if (!allowEmpty && (input == null || input.trim().isEmpty())) {
                    System.out.println("<Вы ввели пустую строку. Попробуйте снова.>");
                    continue;
                }
                return input;
            } catch (Exception ex) {
                System.out.println("<Что-то пошло не так, попробуйте снова.>");
            }
        }
    }
}
