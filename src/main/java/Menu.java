import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.StrictMath.floor;

public class Menu {
    public static void foodList(int numberOfPersons) {
        String money = "\uD83D\uDCB0";
        double totalPrice = 0.0;
        double share;
        StringBuilder food = new StringBuilder("Ваша еда: ");

        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название блюда:");
            String itemName = scanner.nextLine();

            System.out.println("Введите стоимость блюда:");
            while (true) {


                if (!scanner.hasNextDouble()) {
                    System.out.println("Я же попросил ввести цену. Зачем мне твои буквы?");
                    scanner.nextLine();
                } else {
                    double price = scanner.nextDouble();

                    if (price == 0) {
                        System.out.println("Бесплатный сыр, только в мышеловке!");
                    } else if (price < 0) {
                        System.out.println("Ещё и доплатили? Вот это чудеса! " + "Ты точно в ресторане был," +
                                " а не к бабушке заехал?\n Введите стоимость блюда:");
                    } else {
                        food.append("\n").append(itemName).append(" за ").append(price);
                        totalPrice += price;
                        System.out.println("Товар успешно добавлен!");
                        break;
                    }
                }
            }

            System.out.println("Желаете добавить что то еще? Для подсчета введите Завершить");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Завершить")) {
                scanner.close();
                break;
            }
        }
        share = totalPrice / numberOfPersons;
        System.out.println(food);
        System.out.println("******");
        System.out.println("Чек на:  " + rubles(totalPrice));
        System.out.println("Скидываемся по: " + rubles(share) + money);
        System.out.println("******");
        System.out.println("Рекомендуем: \n5% " + rubles(totalPrice * 5 / 100) + " Среднее обслуживание\n7% "
                + rubles(totalPrice * 7 / 100) + " Хорошее обслуживание\n10% " + rubles(totalPrice * 10 / 100)
                + " Отличное обслуживание");

    }

    public static String rubles(double a) {
        if (floor(a) % 10 >= 2 && floor(a) % 10 <= 4) return format(a) + " рубля";
        else if (floor(a) % 10 == 1) return format(a) + " рубль";
        else return format(a) + " рублей";
    }

    public static String format(double a) {
        DecimalFormat dF = new DecimalFormat("#.##");
        // спользовал именно этот метот, так как пишут, что он быстрее, но могу вернуть
        //return String.format("%.2f", a);
        return (dF.format(a));
    }
}
