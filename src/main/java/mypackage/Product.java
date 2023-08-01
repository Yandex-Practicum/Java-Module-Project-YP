package mypackage;

public class Product {

    // Fields (instance variables)
    public String name;
    public double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Methods
    public void displayInfo() {
        System.out.println(name + " " + price);
    }
}
