import java.util.ArrayList;

public class Calculator {
    ArrayList<String> nameDishMenuClient = new ArrayList<>();
    ArrayList<Double> priceDishMenuClient = new ArrayList<>();
    Format formatPeople = new Format();
    ReadLine sizePeople = new ReadLine();
    double sumPriceMenuClient = formatPeople.sumPriceMenu();

    public void calculator(String name, double price) {
        System.out.println(String.format("%s = %s p.", name, price));
    }

    public void basket() {
        System.out.println("Ваш список заказанных блюд:");
        for (int i = 0; i <= nameDishMenuClient.size() - 1; i++) {
            System.out.printf("%s = %s\n", nameDishMenuClient.get(i), priceDishMenuClient.get(i));
        }
        System.out.printf("Общей суммой = %s", sumPriceMenu());
        System.out.printf("Для %s человек с каждого по %.2f %s", sizePeople.quantityPeople,
                 sumPriceMenuClient, "ДОДЕЛЫВАЮ" );
    }

    public double sumPriceMenu() {
        double sum = 0;

        for (int i = 0; i <= priceDishMenuClient.size() - 1; i++) {
            sum += priceDishMenuClient.get(i);
        }
        return sum;
    }
}
