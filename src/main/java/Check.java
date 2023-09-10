public class Check {
    public double sum = 0D;
    public String goodNames = "";

    public void addSum (double newSum) {
        sum += newSum;
    }
    public void addGoodName (String goodNames) {
        String newNames = goodNames + "\n" + goodNames + ";";
        goodNames = newNames;
    }
    public double div (int qPeople) {
        double result = sum/qPeople;
        return result;
    }

}
