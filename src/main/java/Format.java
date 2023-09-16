import static java.lang.Math.floor;

public class Format {
    public float money(int people, float sum){
        float result = sum / Float.parseFloat(String.valueOf(people));
        return result;
    }
    public String ruble(float floatPrice){
        int price = (int) (floatPrice * 100);
        price = price /100 % 100;
        if (price > 20)
            price %= 10;
        else if (price < 5) return "рублей";
        else price %= 10;

        if (price == 1)return "рубль";
        else if (price < 5)  return "рубля";
        else return "рублей";
    }
    public String endString(float cash) {
        String endLine = String.format("Каждый должен оплатить  %.2f %s", cash, ruble(cash));
        return endLine;
    }

}
