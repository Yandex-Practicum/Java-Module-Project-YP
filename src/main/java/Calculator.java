import java.util.ArrayList;

public class Calculator {
    public double priceForOne (int numberOfPeople, ArrayList<Product> products) {
        double sum =0;
        for (Product k :products){
            sum += k.price;
        }
        return sum / numberOfPeople;
    }
}
