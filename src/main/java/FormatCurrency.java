public class FormatCurrency {

    public static String formatCurrency(double amount) {
        int lastDigit = (int) amount % 10;
        int lastTwoDigits = (int) amount % 100;
        String currency;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            currency = "рублей";
        } else if (lastDigit == 1) {
            currency = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            currency = "рубля";
        } else {
            currency = "рублей";
        }

        return String.format("%.2f %s", amount, currency);
    }
}
