public class Calculate{
    int guests;
    double finalPrice;
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
        var ending = Ending.getEnding(rub);
        return ru + " рубл" + ending;
    }
}