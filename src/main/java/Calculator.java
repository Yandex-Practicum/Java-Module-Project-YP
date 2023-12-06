import java.util.Scanner;
public class Calculator {
    public static String processProducts(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название товара.");
        String name = scanner.nextLine();

        return name;

    }

    public static double receiveTheCostOfTheProduct(){
        Scanner scanner = new Scanner(System.in);
        String cost;
        System.out.println("Введите стоимость товара в формате рубли.копейки.");
        while (true) {
            cost = scanner.nextLine();
            if (Formatter.checksForPrice(cost)) {
                break;
            }
        }

        return Double.parseDouble(cost);
    }
}
