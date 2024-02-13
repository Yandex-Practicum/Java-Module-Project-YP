

public class Calculator {
    private double total = 0.0;
    private StringBuilder items = new StringBuilder();

    void addItem(String name, double price) {
        total += price;
        items.append(name).append(": ").append(String.format("%.2f", price)).append(" рубля\n");
    }

    double getTotal() {
        return total;
    }

    String getItems() {
        return items.toString();
    }
}
