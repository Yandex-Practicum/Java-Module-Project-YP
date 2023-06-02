public class Main {
    public static void main(String[] args) {

        for (float i = 0; i < 100; i=i+7.25f) {
            System.out.println( (PriceFormatterToString.priceFormattingToString( i+0.25f)));
           // System.out.println( i);


        }
    }
}


