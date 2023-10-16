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
        System.out.format(Locale.US ,strTemplate, sumPerPerson, getCorrectWordEnd((int)sumPerPerson % 10));
    }

    private String getCorrectWordEnd(int currentValueOfSum) {
        if (currentValueOfSum == 1) return "рубль";
        else if (currentValueOfSum > 1 && currentValueOfSum < 5) return "рубля";
        else if (currentValueOfSum == 0 || currentValueOfSum > 4 && currentValueOfSum <= 9) {
            return "рублей";
        }

        return "error";
    }
}
