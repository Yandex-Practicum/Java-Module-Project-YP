class RubleUtil {
    public static String getRublesFormattedString(double amount) {
        int rubles = (int) amount % 10;

        if (rubles == 1 && ((int) amount) % 100 != 11) {
            return "рубль";
        } else if (rubles >= 2 && rubles <= 4 && ((int) amount) % 100 < 10 || ((int) amount) % 100 >= 20) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
