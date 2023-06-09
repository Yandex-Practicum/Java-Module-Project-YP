public class Calculate{
    int allGuests;
    double finalPrice;
    String catalogProducts = "";

    public Calculate(int guests) {
        allGuests = guests;
    }

    public void list(Products addProducts) {
        finalPrice += addProducts.priceProducts;
        catalogProducts += addProducts.nameProducts + "\n";
    }

    public String result() {
        var division = finalPrice / allGuests;
        var ru = String.format("%.2f", division);
        var rub = Math.floor(division);
        var ending = Ending.getEnding(rub);
        return ru + " рубл" + ending;
    }
}