import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfGuests;

        /*Change the scanner locale for inputting floating point numbers with a dot delimiter
        instead of a comma delimiter. */
        scanner.useLocale(Locale.US);

        //(Part 1) Endless loop to check the correctness of the entered count of guests
        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");

            if (scanner.hasNextInt()) {
                countOfGuests = scanner.nextInt();
            } else {
                System.out.println("Ошибка! Вы ввели не целое число. Пожалуйста, попробуйте снова.\n");
                scanner.nextLine();
                continue;
            }

            if (countOfGuests > 1) {
                break;
            } else if (countOfGuests == 1) {
                System.out.println("Ошибка! Для одного человека нет смысла ничего считать.\n" +
                        "Пожалуйста, попробуйте ввести другое значение.");
            } else {
                System.out.println("Ошибка! Было введено некорректное кол-во гостей.\n" +
                        "Пожалуйта, попробуйте ввести другое значение.\n");
            }
        }

        /*(Part 2) The part with creating a new instance of the "Calculator" class
         and inputting the product name and price from the user */
        Calculator calc = new Calculator(countOfGuests);
        boolean titleIsAlreadyEntered = false;

        scanner.nextLine();

        while (true) {
            if (!titleIsAlreadyEntered) {
                System.out.print("Введите название товара: ");
                calc.addTitleOfProduct(scanner.nextLine());
                titleIsAlreadyEntered = true;
            }
            System.out.print("Введите стоимость товара в формате \"рубли.копейки\": ");
            if (scanner.hasNextDouble()) {
                double priceOfProduct = scanner.nextDouble();
                if (priceOfProduct < 0) {
                    System.out.println("Ошибка! Стоимость добавляемого товара не может быть отрицательной.\n" +
                            "Пожалуйста, попробуйте ввести стоимость снова.");
                    continue;
                }
                calc.addToTotalPrice(priceOfProduct);
            } else {
                System.out.println("Ошибка! Вы ввели не дробное число. Пожалуйста, попробуйте снова.");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();
            titleIsAlreadyEntered = false;
            System.out.println("Товар был успешно добавлен в калькулятор!");
            System.out.println("Хотите ли добавить еще один товар?\n(Введите 'Завершить', чтобы завершить добавление товаров)");
            String usersAnswer = scanner.nextLine();

            if (usersAnswer.equalsIgnoreCase("завершить")) {
                break;
            }
        }

        scanner.close();

        // (Part 3) Output of calculation results to the console
        calc.calculate();
    }
}