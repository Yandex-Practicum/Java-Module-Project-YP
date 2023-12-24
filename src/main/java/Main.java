
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        ResultHandler resultHandler = new ResultHandler();

        int numberOfPeople = inputHandler.getPeopleCount();
        ArrayList<Product> products = inputHandler.getProductsList();
        double priceForOne = calculator.priceForOne(numberOfPeople, products);
        resultHandler.showResult(products, priceForOne);
    }
}
