import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest {
    public static void getGuestInfo(){
        Scanner scanner = new Scanner(System.in);
        int guests = 0;
        while (true) {
            try {
                guests = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка, неверное значение!");
            } finally {
                scanner.nextLine();
            }
            if (guests > 1){
                System.out.println("Вы ввели правильно, делим счет на " + guests);
                break;
            } else if (guests == 1){
                System.out.println("На одного и счет не делиться.");
            } else {
                System.out.println("Это не корректное значение.");
            }
            System.out.println("Давайте попробуем снова.");
        }
        var counting = new Calculate(guests);
        while (true) {
            String nameProducts;
            System.out.println("Что вы выбрали?");
            nameProducts = scanner.nextLine();
            System.out.println("Сколько это стоит?");
            double priceProducts = inputPrice(scanner);
            var addProducts = new Products(nameProducts, priceProducts);
            counting.list(addProducts);
            System.out.println("Список товара обновлен!\nДля продолжение введите ДА, для подсчета итога введите ЗАВЕРШИТЬ");
            var inputUser = scanner.nextLine();
            if (inputUser.equalsIgnoreCase("завершить")) {
                break;
            } if (inputUser.equalsIgnoreCase("да")) {
                System.out.println("Отлично! Продолжаем выбор товаров");
            }
        }
        System.out.println("Ваши товары:");
        System.out.println(counting.catalogProducts);
        System.out.println("Стоимость для каждого гостя:");
        System.out.println(counting.result());
    }
    private static double inputPrice(Scanner scanner) {
        while (true) {
            try {
                var rub = scanner.nextDouble();
                if (rub <= 0) {
                    System.out.println("Ошибка, неверное значение!");
                    continue;
                }
                return rub;
            } catch (InputMismatchException ext) {
                System.out.println("Ошибка, неверное значение!");
            } finally {
                scanner.nextLine();
            }

        }

    }
}
