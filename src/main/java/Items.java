public class Items {
    static double cost;
    static String nameProduct;

    Items(double price, String name) {
        cost = price;
        nameProduct = name;
    }

    public static String nameOfProduct() {
        return nameProduct;
    }
    public static double costOfProduct() {
        return cost;
    }


}

