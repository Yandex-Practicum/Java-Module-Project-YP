import java.util.Scanner;
public class Products {
    Scanner scanner = new Scanner(System.in);
    String nameProducts;
    double priceProducts;

    Products(String nameProducts, double priceProducts) {
        this.nameProducts = nameProducts;
        this.priceProducts = priceProducts;
    }
}
