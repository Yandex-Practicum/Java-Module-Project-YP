
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Validator validator = new Validator();
        Cart cart = new Cart();
        Formatter formatter = new Formatter();
        Calculate calculate = new Calculate();

        System.out.println("Введите количество гостей");

        int countPerson = validator.verifyInt();

        String event = "";

        while (!event.equalsIgnoreCase("Завершить")) {
            System.out.println("Введите наименование товара");
            String name = validator.verifyString();
            System.out.println("Введите стоимость товара");
            double cost = validator.verifyDouble();
            String currency = formatter.formate((int) Math.floor(cost));

            cart.addPurchase(name, cost, currency);
            calculate.sum(cost);

            System.out.println("Добавить новый товар? Чтобы перейти к расчету введите 'Завершить'");
            event = scanner.next();


        }
        cart.printPurchaseList();
        double partPayment = calculate.getResult(countPerson);
        String currency = formatter.formate((int) Math.floor(partPayment));
        System.out.println("Нужно оплатить по " + String.format("%.2f", partPayment) + currency);
    }

}