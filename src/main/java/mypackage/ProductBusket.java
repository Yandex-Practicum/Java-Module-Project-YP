package mypackage;


import java.util.ArrayList;
import java.util.List;


public class ProductBusket {

    public static double finalPrice;
    public List<Product> productList;

    public ProductBusket() {
        this.finalPrice = 0;
        this.productList = new ArrayList<>();
    }

    public void addToBusket(Product productExample) {
        productList.add(productExample);
        finalPrice = finalPrice + productExample.price;

    }

    public void displayProducts() {
        String message = "Добавленные товары: ";
        System.out.println(message);
        for (Product element : this.productList) {
            element.displayInfo();

        }
    }
}