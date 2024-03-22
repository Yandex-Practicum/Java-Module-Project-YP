import java.util.HashMap;import java.util.*;

public class BillCalculator {
    private HashMap<String, Double> products = new HashMap<>();
    private int numberOfPeople;

    public BillCalculator(double totalBill, int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void addProduct(String productName, double price) {
        products.put(productName, price);
    }

    public double getTotalBill() {
        double totalBill = 0.0;
        for (double price : products.values()) {
            totalBill += price;
        }
        return totalBill;
    }

    public double calculatePerPersonBill() {
        double totalBill = getTotalBill();
        return totalBill / numberOfPeople;
    }
    public String getProductsList() {
        StringBuilder productList = new StringBuilder("Добавленные продукты:\n");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            String productName = entry.getKey();
            double price = entry.getValue();
            productList.append(productName).append(": ").append(price).append("\n");
        }
        return productList.toString();
    }

}
