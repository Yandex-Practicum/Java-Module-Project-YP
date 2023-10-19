public class Rubles {
    public String getRubles() {

        double rubles = 0;
        double b = (int) Math.floor(rubles);

        if (b % 10 == 1 && b % 100 != 11) {
            return "рубль";
        } else if ((b % 10 >= 2 && b % 10 <= 4) && (b % 100 < 10 || b % 100 > 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}