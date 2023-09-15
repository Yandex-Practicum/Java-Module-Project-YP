import static java.lang.Math.floor;

public class Format {
    public float money(int people, float sum){
        float result = sum / Float.parseFloat(String.valueOf(people));
        return result;
    }
    public String ruble(float price){
        price = price * 100 %10;
        if (price == 0) return "рубля";
        else return "рубль";
    }
    public String endString(float cash) {
        String endLine = String.format("Каждый должен оплатить  %.2f %s", cash, ruble(cash));
        return endLine;
    }

}
