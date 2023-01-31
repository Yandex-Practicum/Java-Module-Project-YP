public class Calculator {
    private double sumPrice;
    private int numberOfPeople;
    private String products;

    public Calculator(int numberOfPeople) {
        this.products="";
        this.numberOfPeople = numberOfPeople;
    }

    public void addProduct(String productName,double price) {
        products += productName + "\n";
        sumPrice+=price;
    }

    public String getProducts(){
        return products;
    }
    public double getPersonalBill(){
        return sumPrice/numberOfPeople;
    }
}
