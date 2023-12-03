public class FormatRub {

   static double rubAverage = Calculator.priceSum / Calculator.persons;

    public static String formatRub(){
        int priceRemainder = (int)Math.floor(rubAverage);
        if (priceRemainder % 10==1)
            return " рубль";
        else if (priceRemainder % 10==2 || priceRemainder % 10==3 || priceRemainder % 10==4)
            return " рубля";
        else
           return " рублей";
    }





}
