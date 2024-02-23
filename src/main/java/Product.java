import static java.lang.Math.floor;

import java.util.ArrayList;

public class Product {
    double productPrice;

    public double getProductPrice(String [] stringArray) {

        productPrice = Double.parseDouble(stringArray[stringArray.length - 1]);

        return productPrice;
    }

    ArrayList <String> productList = new ArrayList<>();
    String rublesName;
    public void addProductArray(String product) {

        if (floor(productPrice) > 4 && floor(productPrice) < 21 || ((floor(productPrice)/10)%10) > 4 && ((floor(productPrice)/10)%10) < 10 || ((floor(productPrice)/10)%10) == 0 ) {
            rublesName = "рублей";

        }
        else if ( ((floor(productPrice)/10)%10) == 1 || floor(productPrice) == 1) {
            rublesName = "рубль";
        }

        else if ( ((floor(productPrice)/10)%10) > 1 && ((floor(productPrice)/10)%10) < 5 || floor(productPrice) > 1 && floor(productPrice) < 5) {
            rublesName = "рубля";
        }

        productList.add(product + rublesName);
    }

    public ArrayList<String> getProductArray() {
        return productList;
    }

}
