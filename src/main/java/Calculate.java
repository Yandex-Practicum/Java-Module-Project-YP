public class Calculate {
    int sumPrice;
    String catalog = "";

    public Calculate(int guests){
        this.guests = guests;

    }
    public void add(Product prod) {
        sumPrice += prod.priceProducts;

        catalog += prod.nameProducts + "\n";
    }

    public String getResult() {
        var part = sumPrice / guests;
        var r = String.format("%.2f", part);
        var rub = Math.floor(part);
        var suffix = declensions(rub);
        return r + " рубл" + suffix;
    }
}