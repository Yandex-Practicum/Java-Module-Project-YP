public class Product {
    public double price;
    public String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public static void calculation(int persons, double total){
        String text = "Итого счет на одного человека будет %.2f %s";
        double result = total / persons;
        text =  String.format(text,result,(result-Math.floor(result))> 5.0 ? "рубль" : "рубля");
        System.out.println(text);
    }
}
