import java.util.Scanner;
public class Calculator {
    public static String processProducts(){
        Scanner scanner = new Scanner(System.in);
        String products = "";

        System.out.println("Введите название товара.");
        String name = scanner.nextLine();

        return products = name;

    }

    public static double receiveTheCostOfTheProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите стоимость товара в формате рубли.копейки.");
        double cost = scanner.nextDouble();
        while (cost == 0 || cost < 0) {
            System.out.println("Некоректное значение, повторите ввод.");
            cost = scanner.nextDouble();
            if (cost > 0) 
                break;
        }
        return cost;
    }
}
