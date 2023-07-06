import java.util.Scanner;

public class ExpensesCalculator {
    public static void calculate (Scanner scanner, int numberOfGuests) {
        String listOfExpenses = "";
        float totalExpenses = 0.0f;
        while (true) {
            System.out.println("Введите название товара (для завершения введите 'Завершить'):");
            String thing = scanner.next();

            if (thing.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.println("Введите стоимость товара:");
            float price = 0;

            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
            }

            String formattedPrice = "";
            int priceInt = (int) price;
            if (price > 0) {
                formattedPrice = String.format("%.2f %s", price, (priceInt % 10 == 1 && priceInt % 100 != 11) ? "рубль" :
                        (priceInt % 10 >= 2 && priceInt % 10 <= 4 && (priceInt % 100 < 10 || priceInt % 100 >= 20)) ? "рубля" : "рублей");
                listOfExpenses += thing + " " + formattedPrice + "\n";
                totalExpenses += price;
                System.out.printf("Вы купили %s за %s%n", thing, formattedPrice);
            } else {
                System.out.println("Неправильная цена! Пожалуйста, повторите ввод.");
                continue;
            }
            System.out.printf("Список расходов:%n%s", listOfExpenses);
            float perGuest = totalExpenses / numberOfGuests;
            String formattedTotal = String.format("Итого расходов на одного гостя: %.2f %s%n", perGuest,
                    (totalExpenses == 1) ? "рубль" :
                            ((totalExpenses >= 2 && totalExpenses <= 4) || (totalExpenses >= 22 && totalExpenses <= 24) || (totalExpenses >= 32 && totalExpenses <= 34) || (totalExpenses >= 42 && totalExpenses <= 44) || (totalExpenses >= 52 && totalExpenses <= 54) || (totalExpenses >= 62 && totalExpenses <= 64) || (totalExpenses >= 72 && totalExpenses <= 74) || (totalExpenses >= 82 && totalExpenses <= 84) || (totalExpenses >= 92 && totalExpenses <= 94)) ? "рубля" :
                                    "рублей");
            System.out.println(formattedTotal);
        }
    }
}
