public class Food {
    private String name;
    private Double price;

    public Food(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public String getName(String name) {
        return name;
    }

    @Override
    public String toString() {
        return "{name='" + name + "', price=" + price + "}";
    }

}
