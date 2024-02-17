import static java.lang.Math.floor;

import java.util.ArrayList;

public class Product {
    String productName;
    static double productPrice;

    public static double getProductPrice(String [] stringArray) {

        productPrice = Double.parseDouble(stringArray[1]);

        return productPrice;
    }

    static ArrayList <String> productList;
    static String rublesName;
    public static void addProductArray(String product) {

        if (floor(productPrice) > 4 && floor(productPrice) < 21 || ((floor(productPrice)/10)%10) > 4 && ((floor(productPrice)/10)%10) < 10 || ((floor(productPrice)/10)%10) == 0 ) {
            rublesName = "рублей";

        }
        else if ( ((floor(productPrice)/10)%10) == 1 || floor(productPrice) == 1) {
            rublesName = "рубль";
        }

        else if ( ((floor(productPrice)/10)%10) > 1 && ((floor(productPrice)/10)%10) < 5 || floor(productPrice) > 1 && floor(productPrice) < 5) {
            rublesName = "рубля";
        }

        productList.add(product + rublesName + "\\n");
    }

    public static ArrayList getProductArray() {
        return productList;
    }

}
