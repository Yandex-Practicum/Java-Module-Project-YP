package entity;

/* Класс с параметрами "название товара - name" и "цена - price" для добавления товаров в калькулятор */
public class Products {
    String name;
    float price;
    int count;

    /* Конструктор класса */
    public Products(String productsName, float productsPrice, int productsCount) {
        this.name = productsName;
        this.price = productsPrice;
        this.count = productsCount;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

}
