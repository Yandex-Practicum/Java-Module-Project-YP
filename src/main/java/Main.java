import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Здравствуйте! На сколько человек нужно разделить счет?");
        int numberPeople = guestInputCheck();

        Calculate calc = new Calculate();
        System.out.println(calc.addingPosition());

        float bilPerPerson = calc.fullPricePosition / (float) numberPeople;
        System.out.printf("\nКаждый человек должен заплатить: %.2f " + conversationCase(calc.fullPricePosition, numberPeople), bilPerPerson);
    }

    public static String conversationCase(float pricePosition, int numberPeople) { // в методе реализована логика подстановки окончания слова "рубль"
        float splitAccount = pricePosition / numberPeople;
        int lastRank = (int) (splitAccount % 10);
        String cases = " ";
        if (lastRank == 1) {
            cases = "рубль";
        } else if (lastRank >= 2 && lastRank <= 4) {
            cases = "рубля";
        } else if (lastRank >= 5 && lastRank <= 9) {
            cases = "рублей";
        } else {
            cases = "рублей";
        }
        return cases;
    }
    public static int guestInputCheck() { // в этом методе производится проверка не валидный ввод пользователем
        Scanner scanner = new Scanner(System.in);
        int numberPeople;
        while (true) {
            if (scanner.hasNextInt()) {
                numberPeople = Integer.parseInt(scanner.nextLine());
                if (numberPeople <= 1) {
                    System.out.println("Ошибка! Значение не корректно для подсчета. Попробуйте снова! \nНа сколько человек нужно разделить счет?");
                } else {
                    break;
                }
            } else {
                System.out.println("Не корректный ввод! Напишите количество человек цифрами.");
                scanner.nextLine();
            }
        }
        return numberPeople;
    }
}
