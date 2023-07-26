package models;

import java.util.Objects;

import static utils.Currency.getCurencyString;

public class Good {
    private final String name;
    private final double price;
    public Good(String name, double price) {
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
    public String toString() {
        return String.format("%s: %.2f %s", name, price, getCurencyString(getPrice()));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Double.compare(good.price, price) == 0 && Objects.equals(name, good.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
