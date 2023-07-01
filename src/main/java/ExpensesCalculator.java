import java.util.Scanner;

public class ExpensesCalculator {
    public static void calculate (Scanner scanner, String listOfExpenses, int numberOfGuests) {
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

            if (price > 0) {
                listOfExpenses += thing;
                listOfExpenses += " ";
                String formattedPrice;
                if (price == 1) {
                    formattedPrice = String.format("%.2f рубль", price);
                } else if (price >= 2 && price <= 4) {
                    formattedPrice = String.format("%.2f рубля", price);
                } else {
                    formattedPrice = String.format("%.2f рублей", price);
                }
                listOfExpenses += formattedPrice;
                listOfExpenses += "\n";
                totalExpenses += price;
                System.out.println("Вы купили " + thing + " за " + formattedPrice);
            } else {
                System.out.println("Неправильная цена!Попробуйте ещё раз.");
                scanner.next();
            }
            System.out.printf("Список расходов:%n%s", listOfExpenses);
            String formattedTotal;
            float perGuest = totalExpenses / numberOfGuests;
            if (perGuest == 1) {
                formattedTotal = String.format("%.2f рубль", perGuest);
            } else if (perGuest >= 2 && perGuest <= 4) {
                formattedTotal = String.format("%.2f рубля", perGuest);
            } else {
                formattedTotal = String.format("%.2f рублей", perGuest);
            }
            System.out.printf("Итого расходов на одного гостя: %s%n", formattedTotal);
        }
    }
}
