public class RubleFormatter {
    public static String rightForm(double totalSum) {
        double lastTwoNumbers = totalSum % 100;
        double lastNumber = lastTwoNumbers % 10;

        if (lastTwoNumbers >= 11 && lastTwoNumbers <= 14) {
            return "рублей";
        } else if (lastNumber == 1) {
            return "рубль";
        } else if (lastNumber >= 2 && lastNumber <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}






