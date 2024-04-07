import java.util.ArrayList;
public class Calculator {
    ArrayList<Float> prices = new ArrayList<>();
    Formatter rub = new Formatter();
    public void addPrice(float price){
        prices.add(price);
    }
    public void samib() {
        float sum = 0;
        for(Float price : prices) {
            sum += price;
        }
        int result2;
        result2 = (int)Math.floor(sum / Main.quantity);
        float result = sum / Main.quantity;
        rub.formatRub(result2);
        String format = "С каждого по  %.2f %s";
        System.out.println(String.format(format, result, Formatter.padezh));
    }
}