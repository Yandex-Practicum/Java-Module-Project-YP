public class Item {
    private double price;
    private String title;

    public Item(double price, String title) {
        this.price = price;
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s\t%.2f", this.title, this.price);
    }
}
