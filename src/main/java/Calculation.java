public class Calculation {
    public static String everyPeoplePrice(double price ) {

        String readySum = "";

        double priceNoDouble = Math.floor(price);
        int priceName = (int) (priceNoDouble % 10);
        int priceNameUnusial = (int) (priceNoDouble % 100);

        if (priceName == 1) {
            readySum = "рубль.";
        }
        if (priceName>=2 && priceName<=4) {
            readySum = "рубля.";
        }
        if (priceName>=5 && priceName<=9) {
            readySum = "рублей.";
        }
        if(priceName>=10 && priceName<=20) {
            readySum = "рублей.";
        }
        if(priceNameUnusial>=10 && priceNameUnusial<=20)  {
            readySum = "рублей.";
        }
        return readySum;

    }
}
