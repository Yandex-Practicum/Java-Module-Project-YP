package entity;

/* Класс с параметрами "название товара - name" и "цена - price" для добавления товаров в калькулятор */
public class Products {
    String name;
    double price;

    /* Constructor */
    public Products(String productsName, double productsPrice) {
        this.name = productsName;
        this.price = productsPrice;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /* toString */
    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}