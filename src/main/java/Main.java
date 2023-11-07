import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String basketList = "";
        double basketCost = 0.0;

        System.out.println("Здравствуйте!");
        System.out.println("На сколько человек необходимо разделить счёт?");


        int guest;
        while (true) {
            if (scanner.hasNextInt()) {
                guest = scanner.nextInt();
                if (guest <= 1) {
                    System.out.println("Некоректный ввод!\nНа сколько человек необходимо разделить счёт?");
                }
                if (guest > 1) {
                    break;
                }
            }
            if (!scanner.hasNextInt()) {
                System.out.println("Некоректный ввод!\nНа сколько человек необходимо разделить счёт?");
                scanner.next();
            }
        }

        System.out.println("Счет будет разделен между " + guest);

        Calculator calculator = new Calculator();


        do {

            System.out.println("Введите название товара:");
            basketList = scanner.next();
            System.out.println("Введите стоймость товара:");
            while (true) {
                if (!scanner.hasNextDouble()) {
                    System.out.println("Неверный ввод: повторите.");
                    scanner.next();
                }
                if (scanner.hasNextDouble()) {
                    basketCost = scanner.nextDouble();
                    {
                        if (basketCost < 0) {
                            System.out.println("Неверный ввод: повторите.");
                            // scanner.next();
                        }
                        if (basketCost >= 0) {
                            break;
                        }

                    }
                }
            }
            calculator.urn(basketCost);
            calculator.addBasket(basketList);
            calculator.check(guest);

            System.out.println("Товар " + basketList + " добавлен в корзину. Чтобы продолжить введите любой символ, чтобы закончить введите \"Завершить\"");
        }
        while (!scanner.next().equalsIgnoreCase("Завершить"));


        System.out.println("Добавленные товары:" + "\n" + calculator.list);


        double a = calculator.perOne;
        int x;
        if (a%100>11&& a%100<15) { x= (int) (a%100);
        } else {
            x= (int) (a%10);
        }
        if (x==1)
            System.out.println( "Каждый должен по: " + String.format("%.2f", a) + "рублю.");
        else if (x>1&&x<=4)
            System.out.println("Каждый должен по: " + String.format("%.2f", a) + " рубля.");
        else
        System.out.println("Каждый должен по: "+String.format("%.2f", a) + " рублей.");

    }

}



