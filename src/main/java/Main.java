import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int person;
        String menu = "";
        double sum = 0;
        double prisePosition;
        double price;
        String position;

        person = PeopleNumber.count();

        while (true) {
            System.out.println("Введите название блюда или напишите \"завершить\" для дальнейшего подсчета:");
            position = sc.next();

            if(position.equalsIgnoreCase("Завершить")) {
                break;
            }
            menu = menu + "\n" +position;

            System.out.println("Введите цену блюда:");
            if(sc.hasNextDouble()){
                prisePosition = sc.nextDouble();
                if(prisePosition>0) {
                    sum = sum + prisePosition;
                } else {
                    System.out.println("Введенное число меньше нуля");
                }
            } else {
                System.out.println("Введенные данные не являются числом");
            }

        }

        price = sum/person;

        System.out.println("Добавленные товары:" + menu);

        String rub = Calculation.everyPeoplePrice(price);
        String numberRub = String.format("%.2f", price);
        System.out.println("Цена для каждого гостя: " + numberRub + " " + rub);
        sc.close();

    }
}