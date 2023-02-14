public class RubFormat {
    public static String format(double input) {
        int ending = ((int) input);
        String rub  = "рублей";
        if (ending % 10 == 1) {
            rub  = "рубль";
        }
        if ((ending % 10 >= 2) && (ending % 10 <= 4)) {
            rub  = "рубля";
        }
        if ((ending % 100 >= 11) && (ending % 100 <= 20)) {
            rub  = "рублей";
        }
        return rub;
    }
}

