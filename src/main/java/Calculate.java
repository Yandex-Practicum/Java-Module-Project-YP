public class Calculate {
    int sumPrice;
    String catalog = "";
    int guests;

    public Calculate(int guests){
        this.guests = guests;

    }
    public void add(Products prod) {
        sumPrice += prod.priceProducts ;

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