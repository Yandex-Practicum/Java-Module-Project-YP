public class Formatter {
    public static String formatAmount(double amount) {
        int formattedAmount = (int) Math.floor(amount);

        if (formattedAmount % 100 >= 11 && formattedAmount % 100 <= 19) {
            return "рублей";
        } else {
            switch (formattedAmount % 10) {
                case 1:
                    return "рубль";
                case 2:
                    return "рубля";
                case 3:
                    return "рубля";
                case 4:
                    return "рубля";
                case 5:
                    return "рублей";
                case 6:
                    return "рублей";
                case 7:
                    return "рублей";
                case 8:
                    return "рублей";
                case 9:
                    return "рублей";
                case 0:
                    return "рублей";
                default:
                    return "рублей";
            }
        }
    }
}
