import java.util.Scanner;
public class Calculate {
    private final int sumGuests;
    private double totalPrice;
    public String list = "";

    public Calculate(int sumGuests) {

        this.sumGuests = sumGuests;

    }

    public void add(Products p) {
        totalPrice += p.priceProducts;

        list += p.nameProducts + "\n";
    }

    public String getResult() {
        var part = totalPrice / sumGuests;
        var r = String.format("%.2f", part);
        var rub = Math.floor(part);
        var suffix = declensions(rub);
        return r + " рубл" + suffix;
    }
}