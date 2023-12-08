import java.util.Scanner;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            int people = 0;
            System.out.println("На какое количество человек вы планируете разделить счёт.");
            while (true) {
                people = scanner.nextInt();
                if (people == 1)
                    System.out.println("Ошибка.");
                else if (people < 1) {
                    System.out.println("Некорректное значение, введите корректное количество гостей.");
                } else break;
            }
            calculat();

    }
        public static void calculat() {
            String product = " ", allProducts = " ";
            double account = 0.2f;
            double price = 0.0, allPrice = 0.0;
            int people = 2;
            while (true) {
                System.out.println("Введите название товара.");
                product = scanner.next();
                allProducts += product + "\n";
                System.out.println("Введите стоимость товара.");
                price = scanner.nextDouble();
                allPrice += price;
                System.out.println("Товар успешно добавлен.\nДобавить ещё товар?\nДля выхода введите \"завершить\"\nДля продолжения введите что хотите.");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Завершить.") || input.equalsIgnoreCase("Завершить")) {
                    System.out.println("Добавленные товары: \n" + allProducts);
                    account = allPrice;
                    System.out.println("Сумма к оплате: " + account);
                    account /= people;
                    System.out.println("Каждый заплатит: ");
                    break;
                }
            }
            allRub(account);
        }
    public static void allRub(double accountD) {
            if (accountD % 100 >= 11 && accountD % 100 <= 14) {
                System.out.println(accountD + " рублей");
                return;
            } else if (accountD % 10 == 1) {
                System.out.println(accountD + " рубль");
                return;
            } else if (accountD % 10 == 2 || accountD % 10 == 3 || accountD % 10 == 4) {
                System.out.println(accountD + " рубля");
                return;
            } else {
                System.out.println(accountD + " рублей");
                return;

            }
    }
}



