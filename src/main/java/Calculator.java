import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {
    private static int numGuests;

    // Ввод кол-ва гостей. С проверкой на условия
    // 1. Кол-во гостей должно быть в формате числа.
    // 2. Кол-во гостей не должно быть < 1.
    // 3. Если кол-во гостей = 1, то вычисления не нужно произвоить.
    public static int qtyOfGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество гостей: ");
        //int numGuests = 0;
        while (true) {
            try {
                numGuests = scanner.nextInt();
            }catch (InputMismatchException ex) {
                System.out.println("Некорректный ввод, попробуйте еще раз.");
            }finally {
                scanner.nextLine();
            }
            //- Количество человек меньше 1. Это некорректное значение для подсчёта.
            if (numGuests > 1) {
                System.out.println( "Отлично!!! Тогда делим счет на "+numGuests+" гостей :)");
                break;
            }
            // Кол-во равно 1, просим ввести заново.
            if (numGuests == 1) {
                System.out.println("Вы сегодня один, поэтому платите за все сами;) ");
            }
            // Кол-во отрицательное, просим пользователя ввести заново.
            if (numGuests <= 0) {
                System.out.println("Извините, возможно вы ошиблись. Попробуйте еще раз:)");
            }
            System.out.println("Давайте попробуем снова: ");

        }
        return numGuests;
    }
    public static int getTotalGuest() {
        return numGuests;
    }

    // Расчет итоговой цены который должен заплатить каждый гость.
    // Окончания в слове "рубль" зависят от целочисленной части.
    public static double finalCost(double totalCost) {

        int guests = Calculator.getTotalGuest();

        double finalCost = totalCost / guests;
        return finalCost;
    }

    public static String Suf2(double finalCost){
        if (finalCost % 100 >= 11 && finalCost%100 <= 14){
            return "ей";
        } else if (finalCost % 10 == 1) {
            return "ь";
        } else if (finalCost % 10 == 2 || finalCost % 10 == 3 || finalCost % 10 == 4) {
            return "я";
        } else { return "ей";
        }
    }
}
