import java.util.HashMap;

public class Calculator {
    private double productSum;
    private final HashMap<Product, Integer> order = new HashMap<>();

    public void addProduct (Product product, int quantity) {
        if (order.containsKey(product)) {
            int oldQuantity = order.get(product);
            int newQuantity = oldQuantity + quantity;
            order.put(product, newQuantity);
        }else {
            order.put(product, quantity);
        }
        productSum = calculate();
    }

    private double calculate() {
        double sum = 0;
        for (Product product : order.keySet()){
            int quantity = order.get(product);
            sum += product.price * quantity;
        }
        return sum;
    }

    public void showProduct(){
        System.out.println("Список товаров: ");
        for (Product product : order.keySet()){
            System.out.println(product.name + " " + String.format("%.2f", product.price));
        }
    }

    public double getProductsum() {
        return productSum;
    }

    public String rublesFormat(double rubles) {
        int lastDigit = (int) (Math.floor(rubles) % 10);
        if (((int) (Math.floor(rubles) % 100)) <= 19 && ((int)(Math.floor(rubles) % 100)) >= 11)
            return "рублей";
        switch (lastDigit)  {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }


}
