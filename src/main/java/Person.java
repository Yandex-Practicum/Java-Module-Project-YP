import java.util.ArrayList;
import java.util.Scanner;

public class Person {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> persons = new ArrayList<>();
    private static final Calculate calculate = new Calculate();

    public static void start() {
        System.out.println("На скольких человек необходимо разделить счёт? Введите число.");

        while (true) {
            int countPeople;

            try {
                countPeople = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение. Введите целое число.");
                continue;
            }

            if (countPeople == 1) {
                System.out.println("Количество гостей должно быть больше одного");
            } else if (countPeople < 1) {
                System.out.println("Количество гостей должно быть больше одного");
            } else {
                for (int i = 0; i < countPeople; i++) {
                    persons.add("Гость_" + (i + 1));
                }

                System.out.println("Счет будет разделён на " + countPeople + " человек");
                for (int i = 0; i < persons.size(); i++) {
                    calculate.calculate(persons.get(i));
                }
                double result = calculate.countProducts / persons.size();
                int rubText = (int) result;
                System.out.printf("\nДобавленные блюда всех гостей:\n%s \nСумма к оплате с каждого гостя: %.2f %s", calculate.check, result, calculate.convertRubDeclination(rubText));
                break;
            }

        }
    }


}
