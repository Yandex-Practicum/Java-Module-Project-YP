import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int person;
        String menu = "";
        double sum = 0;
        double prisePosition;
        double price;
        String position;

        person = PeopleNumber.count();

        while (true) {
            System.out.println("Введите название блюда или напишите \"завершить\" для дальнейшего подсчета:");
            position = scanner.next();

            if (position.equalsIgnoreCase("завершить")) {
                break;
            }

            menu = menu + "\n" + position;


            while (true) {
                System.out.println("Введите цену блюда:");
                if (scanner.hasNextInt()) {
                    prisePosition = Integer.parseInt(scanner.nextLine());
                    if(prisePosition>0) {
                        sum = sum + prisePosition;
                        break;
                    } else {
                        System.out.println("Вы ввели некорректную цену");

                    }

                } else {
                    System.out.println("Вы ввели не число");
                    return;
                }
            }

        }

        price = sum/person;

        System.out.println("Добавленные товары:" + menu);

        String rub = Calculation.everyPeoplePrice(price);
        String numberRub = String.format("%.2f", price);
        System.out.println("Цена для каждого гостя: " + numberRub + " " + rub);
        scanner.close();

    }
}