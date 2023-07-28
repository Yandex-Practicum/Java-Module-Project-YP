import java.util.ArrayList;

public class Calculator {
    static int peoples;
    static ArrayList<Product> bill;

    public Calculator (int peoples, ArrayList<Product> bill) {
        Calculator.peoples = peoples;
        Calculator.bill = bill;
    }

    public void printProducts() {
        System.out.println("Список ваших покупок:");
        for (int i = 0; i < bill.size(); i++) {
            System.out.println(bill.get(i).name);
        }
    }

    public double calculateBill () {
        double sum = 0.0;
        for (int i = 0; i < bill.size(); i++) {
            sum += bill.get(i).price;
        }

        return sum;
    }

    public double calculatePrice () {
        return calculateBill() / peoples;
    }

    public void printSum () {
        Formatter formatter = new Formatter();
        double sum = calculatePrice();
        System.out.println("Каждый человек должен заплатить " + String.format("%.2f", sum) + " " + formatter.format(sum));
    }
}
