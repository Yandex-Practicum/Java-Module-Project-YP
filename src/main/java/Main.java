import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        System.out.println("Добрый день!");
        Calculator.GoodsPrice();
    }


    public static int getPeopleCount() {
        Scanner scanner = new Scanner(System.in);
        int peopleCount=0;
        System.out.println("На сколько человек разделить счет?");
        while (true) {
            if(scanner.hasNextInt()) {
                peopleCount = scanner.nextInt();
                if (peopleCount == 1) {
                    System.out.println("Извините, но тогда нет смысла разделять счет.");
                } else if (peopleCount < 1) {
                    System.out.println("Извините, это некорректное значение для подсчета.");
                } else {
                    System.out.println("Спасибо. Информация принята");
                    break;
                }
            }
            else {
                System.out.println("Нужно ввести число");
                scanner.next();
            }
            System.out.println("Попробуйте ввести количество людей еще раз.");
        }
        return peopleCount;
    }
}
