package model;

public class Product {

    private String productName;
    private double priceProduct;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(String productName, double priceProduct) {
        this.productName = productName;
        this.priceProduct = priceProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return priceProduct;
    }

    public void setPrice(double price) {
        this.priceProduct = price;
    }

    @Override
    public String toString() {
        return "model.Product{" +
                "productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
