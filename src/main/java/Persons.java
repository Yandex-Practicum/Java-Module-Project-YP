import java.util.Scanner;
public class Persons {
    Scanner scanner = new Scanner(System.in);
        int newpersone;

    public void quantityPersons() {
        System.out.println("Введите количество гостей:");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Введите число!");
        }
        while (true) {
            newpersone = scanner.nextInt();
            if (newpersone > 1) {
                System.out.println("На " + newpersone + " гостей будет поделен счет.\n");
                break;
            }
            else if (newpersone < 1) {
                System.out.println("Введите корректное число гостей");
            }
            else {
                System.out.println("Некорректные данные");
            }
        }   System.out.println("Для завершения добавления товаров и расчета стоимости напечатайте \"Завершить\"или");
    }
}
