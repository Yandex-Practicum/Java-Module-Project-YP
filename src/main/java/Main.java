import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfGuests;

        //(Part 1) Endless loop to check the correctness of the entered count of guests
        while(true) {
            System.out.println("На сколько человек необходимо разделить счет?");

            if (scanner.hasNextInt()) { countOfGuests = scanner.nextInt(); }
            else {
                System.out.println("Ошибка! Вы ввели не целое число. Пожалуйста, попробуйте снова.\n");
                continue;
            }

            if (countOfGuests > 1) {
                break;
            }
            else {
                System.out.println("Ошибка! Было введено некорректное кол-во гостей.\nПожалуйта, попробуйте снова.\n");
            }
        }

        /*(Part 2) The part with creating a new instance of the "Calculator" class
         and inputting the product name and price from the user */
        Calculator calc = new Calculator(countOfGuests);
        boolean titleIsAlreadyEntered = false;

        while(true) {
            if (!titleIsAlreadyEntered) {
                System.out.print("Введите название товара: ");
                calc.addTitleOfProduct(scanner.next());
                titleIsAlreadyEntered = true;
            }
            System.out.print("Введите стоимость товара в формате \"рубли.копейки\": ");
            if (scanner.hasNextDouble()) {calc.addToTotalPrice(scanner.nextDouble());}
            else {
                System.out.println("Ошибка! Вы ввели не дробное число. Пожалуйста, попробуйте снова.");
                continue;
            }

            titleIsAlreadyEntered = false;
            System.out.println("Хотите ли добавить еще один товар?\n(Введите 'Завершить', чтобы завершить добавление товаров)");
            String usersAnswer = scanner.next();

            if (usersAnswer.equalsIgnoreCase("завершить")) {break;}
        }

        scanner.close();

        // (Part 3) Output of calculation results to the console
        calc.calculate();
    }
}