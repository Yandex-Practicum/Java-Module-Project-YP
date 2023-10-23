public class Rubles {
    public String getRubles(int rublesInt) {
        if (rublesInt % 10 == 1 && rublesInt % 100 != 11) {
            return "рубль";
        } else if ((rublesInt % 10 >= 2 && rublesInt % 10 <= 4) && (rublesInt % 100 < 10 || rublesInt % 100 > 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}