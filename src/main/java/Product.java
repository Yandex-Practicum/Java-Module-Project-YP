public class Product {
    public double price;
    public String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public static void calculation(int persons, double total) {
        String text = "Итого счет на одного человека будет %.2f %s";
        double result = total / persons;
        String rub = "рубль";
        if (Math.floor(result) >= 5 ) {
            rub = "рублей";
        } else if (Math.floor(result) < 5 && Math.floor(result) > 1){
            rub = "рубля";
        }
        text = String.format(text, result,rub);
        System.out.println(text);
    }
}
