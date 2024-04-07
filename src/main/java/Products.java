import java.util.ArrayList;
public class Products {
   ArrayList<String> products = new ArrayList<>();
   public void addProduct(String product){
       products.add(product);
   }
   public void outputProducts() {
       for(String product : products) {
           System.out.println(product);
       }
   }
}