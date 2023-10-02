public class Calculation {
    public static String everyPeoplePrice(double price ) {

        String readysum;

        double price2 = Math.floor(price);
        int priceName = (int) (price2 % 10);

        if (priceName == 1) {
            readysum = "рубль.";
        } else if (priceName>=2 && priceName<=4) {
            readysum = "рубля.";
        } else {readysum = "рублей.";
        }
        if(price2>=10 && price2<=20) {
            readysum = "рублей.";
        }
        return readysum;

    }
}
