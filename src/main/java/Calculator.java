import java.util.ArrayList;

public class Calculator {
    double amountProduct;
    ArrayList<Product> productsList = new ArrayList<>();

    void addProduct(Product product){
        amountProduct += product.price;
        productsList.add(product);
        System.out.println("Товар успешно добавлен.");
    }
}
