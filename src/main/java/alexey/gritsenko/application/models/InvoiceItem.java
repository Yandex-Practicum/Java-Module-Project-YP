package alexey.gritsenko.application.models;

public record InvoiceItem(String productName, double cost) {

    @Override
    public String toString() {
        return " Продукт: '" + productName + '\'' +
                ", стоимость: " + cost;
    }
}
