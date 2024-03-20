import java.util.HashMap;

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
        for (String productName : products.keySet()) {
            productList.append(productName).append(": ").append(products.get(productName)).append("\n");
        }
        return productList.toString();
    }

}
