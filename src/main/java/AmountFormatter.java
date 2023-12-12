public class AmountFormatter {
    public static String format(double amount) {
        int lastDigit = (int) amount % 10;
        int lastTwoDigits = (int) amount % 100;

        String format = "%.2f рублей";

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return String.format(format, amount);
        } else {
            switch (lastDigit) {
                case 1:
                    format = "%.2f рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    format = "%.2f рубля";
                    break;
            }
            return String.format(format, amount);
        }
    }
}

