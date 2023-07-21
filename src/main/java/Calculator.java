import java.util.List;

public class Calculator {
    private final List<Item> items;
    private final int amountOfPeople;

    public Calculator(int amountOfPeople, List<Item> items) {
        this.amountOfPeople = amountOfPeople;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPerPersonAmount() {
        double overallPrice = items.stream().map(Item::getPrice).reduce(Double::sum).orElse(0.0);
        return overallPrice / this.amountOfPeople;
    }
}
