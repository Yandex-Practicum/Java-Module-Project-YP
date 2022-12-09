public class Ruble {
    String amountOfRubles;

    public void writeRuble(double floatAmount) {
        int amount = (int) Math.floor(floatAmount);
        int a = amount % 100;
        int b = a % 10;

        if (a >= 11 & a <= 19) {
            amountOfRubles = String.format("%.2f", floatAmount) + " рублей";
        } else if (b == 1) {
            amountOfRubles = String.format("%.2f", floatAmount) + " рубль";
        } else if (b == 2 | b == 3 | b == 4) {
            amountOfRubles = String.format("%.2f", floatAmount) + " рубля";
        } else {
            amountOfRubles = String.format("%.2f", floatAmount) + " рублей";
        }
    }

}
