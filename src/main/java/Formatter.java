public class Formatter {
    public static String getRubleAddition(double num) {
        int numInt = (int) num;
        int lastTwoDigits = numInt % 100;
        int lastDigit = numInt % 10;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return "рублей";
        } else if (lastDigit == 1) {
            return "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "рубля";
        }
        return "рублей";
    }


    public static double round(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
