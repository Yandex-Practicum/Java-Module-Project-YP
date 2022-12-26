import java.util.ArrayList;
import java.util.Scanner; // импортируем модуль Scanner

public class SplitTheBill {
    int personsQuantity;      // Количество человек
    /*
    Полученный в ходе выполнения товар должен быть добавлен в калькулятор.
    Для этого используем улучшенный массив неопределенной длинны,
    состоящий из элементов класса FoodElement
     */
    ArrayList<FoodElement> billElementList = new ArrayList<FoodElement>();

    void quantityQuestionaire() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                System.out.println("Похоже, что вы ввели не число. Введите число.");
                scanner.next(); // this is important!
            }

            personsQuantity = scanner.nextInt();
            // TODO Задание 1 пункт 2 — проверки на некорректные значения количества людей
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

    float calculatorPerPerson() {
        float totalCost = 0;
        float result;
        for (int i = 0; i < billElementList.size(); i++) {
            totalCost += Float.valueOf(billElementList.get(i).foodPrice);
        }
        /*
        Мы рискуем получить дробь с числом знаков после запятой больше чем 2
        Поэтому мы должны округлить дробь до 2 знаков после запятой

        Для этого используем класс Math, который работает только с целыми числами,
        но округляет вниз до ближайшего целого числа.
        То есть мы сначала умножаем нашу дробь на 100, а потом делим на 100. Получаем уже округленное значение.

        Вторая проблема: после округления может получиться, что сумма платежей каждого участника будет
        меньше чем сумма всего счета, в такой ситуации мы добавляем к счету каждого участника по одной копейке 0.01
         */
        result = (float) Math.round(100 * totalCost / personsQuantity) / 100;
        System.out.println(result);
        if ((totalCost - result * personsQuantity) > 0) {
            System.out.println("ВНИМАНИЕ");
            String messageTemplate = "Разделили %.2f на %d человек. Получили %.2f.\nПри умножении на %d получим сумму меньше чем сумма всего счёта: %.2f";
            System.out.printf(messageTemplate, totalCost, personsQuantity, result, personsQuantity, (float) result * personsQuantity);

            System.out.println("Если не увеличить оплату каждого на 1 копейку, то заведение недополучит денег");
            System.out.println("Добавили +0.01 к каждому платежу");
            result += 0.01;
            System.out.println("После оплаты останется сдача (на чай): " + (float) Math.round(100 * (result * personsQuantity - totalCost)) / 100);
        } else if ((totalCost - result * personsQuantity) < 0) {
            System.out.println("ВНИМАНИЕ");
            System.out.println("После оплаты останется сдача (на чай): " + (float) Math.round(100 * (result * personsQuantity - totalCost)) / 100);
        }
        return result;
    }


}