import java.util.List;
import java.util.Objects;

public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Item otherItem)) { return false; }
        return otherItem.name.equals(this.name) && (otherItem.price == this.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price);
    }
}
