import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("На сколько людей необходимо разделить счет?");
        int users = people();
        calculate();
        cheque(users);

    }


    public static int people() {
        int users = getInput();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (users == 1) {
                System.out.println("Делить нечего");
                break;
            }
            if (users <= 1) {
                System.out.println("Ошибка, введите число повторно");
                users = scanner.nextInt();
            }
            if (users > 1) {
                System.out.println("Делим счет на " + users);
                break;
            }
        }
        return users;
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Введите корректное число");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    public static void calculate() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            System.out.println("Введите название товара или 'Завершить' для завершения работы калькулятора");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара");
            double productPrice = scanner.nextDouble();
            System.out.println("Товар успешно добавлен в калькулятор.");
            scanner.nextLine();
            Items items = new Items(productPrice, productName);
            calculator.productsSum(items);
            calculator.addNewProducts(items);
        }


    }

    public static void cheque(int users) {
        Calculator calculator = new Calculator();
        Payment payment = new Payment(calculator.chequePerPerson(),users);
        payment.paymentPerPerson();

    }


}
