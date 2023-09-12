import java.util.Scanner;

public class ExpensesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGuests = 5;
        calculate(scanner, numberOfGuests);
    }

    public static void calculate(Scanner scanner, int numberOfGuests) {
        String listOfExpenses = "";
        float totalExpenses = 0.0f;
        while (true) {
            System.out.println("Введите название товара (для завершения введите 'Завершить'):");
            String thing = scanner.next();

            if (thing.equalsIgnoreCase("Завершить")) {
                break;
            }

            System.out.println("Введите стоимость товара:");
            float price = 0;

            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
            }

            String formattedPrice = "";
            if (price > 0) {
                formattedPrice = String.format("%.2f %s", price, getEnding(price, "рубль", "рубля", "рублей"));
                listOfExpenses += thing + " " + formattedPrice + "\n";
                totalExpenses += price;
                System.out.printf("Вы купили %s за %s\n", thing, formattedPrice);
            } else {
                System.out.println("Неправильная цена! Попробуйте ещё раз.");
                scanner.next();
            }
            System.out.printf("Список расходов:%n%s", listOfExpenses);
            float perGuest = totalExpenses / numberOfGuests;
            String formattedTotal = String.format("Итого расходов на одного гостя: %.2f %s%n", perGuest, getEnding(perGuest, "рубль", "рубля", "рублей"));
            System.out.println(formattedTotal);
        }
    }

    public static String getEnding(float number, String form1, String form2, String form3) {
        int numberInt = (int) number;
        int mod10 = numberInt % 10;
        int mod100 = numberInt % 100;
        if (mod10 == 1 && mod100 != 11) {
            return form1;
        } else if (mod10 >= 2 && mod10 <= 4 && (mod100 < 10 || mod100 >= 20)) {
            return form2;
        } else {
            return form3;
        }
    }
}