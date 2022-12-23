import java.util.Scanner; // импортируем модуль Scanner

public class SplitTheBill {
    int personsQuantity = 0;      // Количество человек

    public static int quantityQuestionaire (int personsQuantity) {
        boolean isCorrect = false;
        personsQuantity = personsQuantity;
        while (!isCorrect) {
            Scanner scanner = new Scanner(System.in);
            personsQuantity = scanner.nextInt();
            if (personsQuantity == 1) {
            /*
            Количество человек, введённых пользователем, равно 1.
            В этом случае нет смысла ничего считать и делить.
             */
                System.out.println("Для одного человека не надо ничего считать.");
                isCorrect = false; // перегружаем код, чтобы упростить читабельность
            } else if (personsQuantity < 1) {
            /*
            Количество человек меньше 1. Это некорректное значение для подсчёта.
             */
                System.out.println("Некорректное значение! Чек не мог быть выписан в отсутствии людей.");
                isCorrect = false;
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
                isCorrect = true; // когда число больше 1 выходим из цикла.

            }

        }
        return personsQuantity;
    }

}