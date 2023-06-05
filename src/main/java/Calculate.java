public class Calculate{
    int guests;
    int finalPrice;
    String catalogProducts;

    public Calculate(int guests) {
        this.guests = guests;
    }

    public void list(Products prod) {
        finalPrice += prod.priceProducts;
        catalogProducts += prod.nameProducts;
    }

    public String result() {
        var division = finalPrice / guests;
        var ru = String.format("%.2f", division);
        var rub = Math.floor(division);
        var ending = getEnding(rub);
        return ru + " рубл" + ending;
    }

    public static String getEnding(double rub) {
        if (rub % 100 >= 11){
            return "ей";
        } else if (rub % 10 == 1) {
            return "ь";
        } else if (rub % 10 == 4) {
            return "я";
        } else if (rub % 100 <= 14) {
            return "ей";
        } else if (rub % 10 == 2) {
            return "я";
        } else if (rub % 10 == 3) {
            return "ей";
        }else {
            return "ей";
        }
    }
}