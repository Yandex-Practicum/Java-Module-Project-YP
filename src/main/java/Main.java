import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfPeople = 0;

        System.out.println("Введите количество человек:");

        do {
            try {
                numOfPeople = scanner.nextInt();
                if (numOfPeople < 1)
                    System.out.println("Некорректный ввод. Введите еще раз!");
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите еще раз!");
                scanner.nextLine();
            }
        }
        while (numOfPeople < 1);

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> priceByItems = new ArrayList<>();

        System.out.println("Введите список товаров в формате \"товар цена\"");
        System.out.println("Чтобы остановить ввод - введите \"завершить\"");

        while (true) {
            String item = scanner.next();
            if (item.toLowerCase().equals("завершить")) {
                break;
            }
            try {

                items.add(item);
                priceByItems.add(Double.parseDouble(scanner.next()));
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }

        System.out.println("Добавленные товары:");
        double sum = 0;
        for (int i = 0; i < priceByItems.size(); i++) {
            System.out.println(items.get(i) + " - " + Math.ceil(priceByItems.get(i) * 100) / 100 + " " + CurrentOutput.ruble(priceByItems.get(i)));
            sum += priceByItems.get(i);
        }
        System.out.println("Каждый человек должен заплатить - " + Math.ceil(sum / numOfPeople * 100) / 100 + " " + CurrentOutput.ruble(Math.ceil(sum / numOfPeople * 100) / 100));
    }
}

class CurrentOutput {
    static String ruble(double price) {
        int lastDigit = (int) price % 10;
        int twoLastDigits = (int) price % 100;
        if ((twoLastDigits >= 11 && twoLastDigits <= 14) || lastDigit == 0 || (lastDigit >= 5 && lastDigit <= 9))
            return "рублей";
        else if (lastDigit == 1)
            return "рубль";
        else return "рубля";
    }
}
