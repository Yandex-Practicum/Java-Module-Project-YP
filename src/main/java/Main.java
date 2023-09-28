import com.sun.source.tree.WhileLoopTree;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Добрый день! На сколько гостей желаете разделить счет?");
        Scanner scanner = new Scanner(System.in);
        int guestNumber;
        while (true) {
            if (scanner.hasNextInt()) {
                guestNumber = scanner.nextInt();
                if (guestNumber > 1) {
                    System.out.println("Спасибо! Сейчас рассчитаем ваше меню.");
                    break;
                } else {
                    System.out.println("Ошибка! Вы ввели некорректное количество гостей! Пожалуйста, повторите попытку.");
                }
            } else {
                System.out.println("Ошибка! Вы не ввели число! Перезапустите программу и попробуйте снова.");
                return;
            }
        }
        Calculator calculator = new Calculator();
        calculator.addGoods();
        calculator.calculatePayment(guestNumber);

    }
}