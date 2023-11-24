import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        int numOfPeople = 0;
        Calculator calculator;
        Helpers helper = new Helpers();
        Scanner scanner = new Scanner(System.in);

        boolean isValid = false;
        numOfPeople = helper.splitBetweenPeople(isValid, scanner);

        boolean isAddingNewProduct = false;
        productList = helper.addProducts(isAddingNewProduct, scanner, productList);

        calculator = new Calculator(productList, numOfPeople);
        calculator.printListOfProducts();

    }
}