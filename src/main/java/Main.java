import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
class Calculator {
    private int numOfPeople;
    private double totalCost;
    private String items;

    public Calculator() {
        numOfPeople = 0;
        totalCost = 0.0;
        items = "";
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество человек: ");
            numOfPeople = scanner.nextInt();

            if (numOfPeople == 1) {
                System.out.println("Ошибка: некорректное количество человек");
            } else if (numOfPeople < 1) {
                System.out.println("Ошибка: некорректное значение для подсчета");
            } else {
                break;
            }
        }
        System.out.println("Добавление товаров. Введите 'завершить' для окончания.");
        while (true) {
            System.out.println("Введите название товара: ");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара: ");
            double itemCost = scanner.nextDouble();

            addItem(itemName, itemCost);
            System.out.println("Товар успешно добавлен.");
        }
        System.out.println("Добавленные товары:\n" + items);
        System.out.println("Сумма, которую должен заплатить каждый человек: " + calculateCostPerPerson());
    }
public void addItem(String itemName, double itemCost) {
        items += itemName + "\n";
        totalCost += itemCost;
}
public String calculateCostPerPerson() {
        double costPerPerson = totalCost / numOfPeople;

        int costInt = (int) costPerPerson;
        double costSharing = costPerPerson - costInt;
        int roundedNum = (int) Math.floor(costSharing * 100);
        
        String formattedCost = String.format("%.2f", costPerPerson);
        
        if (costInt % 10 == 1 && costInt % 100 != 11) {
            return formattedCost + " рубль";
        } else if ((costInt % 10 >= 2 && costInt % 10 <= 4) && !(costInt % 100 >= 12 && costInt % 100 <= 14)) {
            return formattedCost + " рубля";
        } else {
            return formattedCost + " рублей";
        }
    }
}