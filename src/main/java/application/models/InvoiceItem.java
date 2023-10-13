package application.models;

public class InvoiceItem {
    private final String productName;
    private final double cost;

    public InvoiceItem(String productName, double cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return " Продукт: '" + productName + '\'' +
                ", стоимость: " + cost ;
    }
}
