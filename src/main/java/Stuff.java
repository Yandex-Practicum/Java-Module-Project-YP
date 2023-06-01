import java.util.Scanner;


public class Stuff {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    String keyWOrd1 = "завершить";
    Double price;
    public double priceStuf(){
        if(this.name.equalsIgnoreCase(keyWOrd1)){
            return 0;
        }else {
            price = scanner.nextDouble();
        }
        return price;
    }
}
