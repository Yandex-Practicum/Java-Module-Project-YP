import java.util.ArrayList;
import java.util.Scanner; // импортируем модуль Scanner

public class SplitTheBill {
    int personsQuantity;      // Количество человек
    ArrayList<FoodElement> billElementList = new ArrayList<FoodElement>();
    void quantityQuestionaire () {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            personsQuantity = scanner.nextInt();
            if (personsQuantity == 1) {
            /*
            Количество человек, введённых пользователем, равно 1.
            В этом случае нет смысла ничего считать и делить.
             */
                System.out.println("Для одного человека не надо ничего считать.");
                System.out.println("Пожалуйста введите число больше 1.");
            } else if (personsQuantity < 1) {
            /*
            Количество человек меньше 1. Это некорректное значение для подсчёта.
             */
                System.out.println("Некорректное значение! Чек не мог быть выписан в отсутствии людей.");
                System.out.println("Пожалуйста введите число больше 1.");
            } else {
            /*
            Если пользователь ввёл корректное значение > 1,
            то программа продолжает выполнение.
            Если значение некорректное, то показать ошибку
            и заново попросить пользователя ввести корректное количество гостей.
            Запрашивать количество гостей необходимо до тех пор,
            пока не будет введено корректное значение > 1.
             */
                System.out.println("Прекрасно, начинаем считать счёт!");
                break;

            }

        }
    }

}