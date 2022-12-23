import java.util.Scanner;

public class Product {
    String name;
    float priсe;
    Product (String name,float priсe){
        this.name=name;
        this.priсe=priсe;
    }

    public static Product addNewProduct(){
        Scanner product = new Scanner(System.in);
        System.out.println("Введите название товара");
        String productName = product.next();
        System.out.println("Введите цену товара");
        String sproductPrice = product.next();
        while (!checkForNormalNumber(sproductPrice)){
            System.out.println("Введите корректную цену, рубли.копейки, например 10.45 или 11.40., c двумя числами после запятой!");
             sproductPrice = product.next();
        }

        return new Product(productName,Float.parseFloat(sproductPrice));
    }

    public static boolean checkForNormalNumber (String price){
        return price.matches("\\d+(|\\.)\\d{2}");

    }

}
