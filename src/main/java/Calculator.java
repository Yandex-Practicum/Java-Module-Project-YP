import java.util.ArrayList;
import java.util.Locale;

public class Calculator {
    private final int countOfPeople;
    private double totalSum;
    private final ArrayList<String> titlesOfAddedProducts = new ArrayList<>();

    Calculator(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void addToTotalPrice(double priceOfProduct) {
        totalSum += priceOfProduct;
    }

    public void addTitleOfProduct(String titleOfProduct) {
        titlesOfAddedProducts.add(titleOfProduct);
    }

    private void printAllAddedProducts() {
        System.out.println("Добавленные товары:");
        for (String titleOfProd : titlesOfAddedProducts) {
            System.out.println(titleOfProd);
        }
    }

    //Function for splitting the bill
    public void calculate() {
        double sumPerPerson = totalSum / countOfPeople;
        String strTemplate = "Сумма на одного человека: %.2f %s.";

        printAllAddedProducts();
        System.out.format(Locale.US, strTemplate, sumPerPerson, getCorrectWordEnd((int) sumPerPerson % 100));
    }

    private String getCorrectWordEnd(int currentValueOfSum) {
        if (currentValueOfSum % 10 == 0 || currentValueOfSum % 10 > 4 || currentValueOfSum >= 11 && currentValueOfSum <= 19) {
            return "рублей";
        } else if (currentValueOfSum % 10 == 1) return "рубль";
        else if (currentValueOfSum % 10 > 1 && currentValueOfSum % 10 < 5) return "рубля";

        return "error";
    }
}
