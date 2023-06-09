import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest {
    public static void guest(){
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
            System.out.println("Давайте попробуем снова: ");
        }
        var cal = new Calculate(guests);
        while (true) {
            String nameProducts;
            System.out.println("Что вы выбрали?");
            nameProducts = scanner.nextLine();
            System.out.println("Сколько это стоит?");
            double priceProducts = inputPrice(scanner);
            var prod = new Products(nameProducts, priceProducts);
            cal.list(prod);
            System.out.println("Список товара обновлен!\nДля продолжение введите ДА, для подсчета итога введите ЗАВЕРШИТЬ");
            var input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        System.out.println("Ваши товары");
        System.out.println(cal.catalogProducts);
        System.out.println("Их стоимость");
        System.out.println(cal.result());
    }
    private static double inputPrice(Scanner scanner) {
        while (true) {
            try {
                var ru = scanner.nextDouble();
                if (ru <= 0) {
                    System.out.println("Ошибка, неверное значение!");
                    continue;
                }
                return ru;
            } catch (InputMismatchException ext) {
                System.out.println("Ошибка, неверное значение!");
            } finally {
                scanner.nextLine();
            }

        }

    }
}
