import java.util.List;
import java.util.ArrayList;


public class Calculator {
    int peopleCount;
    double check;
    List<Product> products = new ArrayList<>();
    public Calculator (int newPeopleCount) {
        peopleCount = newPeopleCount;
    }
    public void addProduct (Product newProduct) {
        products.add(newProduct);
        check += newProduct.price;
    }
    public int getPeopleCount () {
        return peopleCount;
    }
    public double getCheck () {
        return check;
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getDividedCheck () {
        return check/peopleCount;
    }
}
