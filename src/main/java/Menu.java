import java.text.DecimalFormat;

import static java.lang.StrictMath.floor;

public class Menu {
    static final String MONEY = "\uD83D\uDCB0";

    public static void foodList(int numberOfPersons) {

        double totalPrice = 0.0;
        double share;
        StringBuilder food = new StringBuilder("Ваша еда: ");

        while (true) {


            System.out.println("Введите название блюда:");

            String itemName = Main.scanner.nextLine();

            System.out.println("Введите стоимость блюда:");
            while (true) {


                if (!Main.scanner.hasNextDouble()) {
                    System.out.println("Я же попросил ввести цену. Зачем мне твои буквы?");
                    Main.scanner.nextLine();
                } else {
                    double price = Main.scanner.nextDouble();

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
            String answer = Main.scanner.next();

            if (answer.equalsIgnoreCase("Завершить")) {
                Main.scanner.close();
                break;
            }
        }
        share = totalPrice / numberOfPersons;
        System.out.println(food);
        System.out.println("******");
        System.out.println("Чек на:  " + rubles(totalPrice));
        System.out.println("Скидываемся по: " + rubles(share) + MONEY);
        System.out.println("******");
        System.out.println("Рекомендуем: \n5% " + rubles(totalPrice * 5 / 100) + " Среднее обслуживание\n7% "
                + rubles(totalPrice * 7 / 100) + " Хорошее обслуживание\n10% " + rubles(totalPrice * 10 / 100)
                + " Отличное обслуживание");

    }

    public static String rubles(double a) {
        double b = floor(a);
        if (b % 100 >= 11 && b % 100 <= 14) return format(a) + " рублей";
        else if (b % 10 >= 2 && b % 10 <= 4) return format(a) + " рубля";
        else if (b % 10 == 1) return format(a) + " рубль";
        else return format(a) + " рублей";
    }

    public static String format(double a) {
        DecimalFormat dF = new DecimalFormat("#.##");
        // спользовал именно этот метот, так как пишут, что он быстрее, но могу вернуть
        //return String.format("%.2f", a);
        return (dF.format(a));
    }
}
