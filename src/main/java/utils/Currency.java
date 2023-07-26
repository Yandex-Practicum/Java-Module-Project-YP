package utils;

public class Currency {
    public static String getCurencyString(double price) {
        var mainPart = (int)price;
        var preLastDigit = mainPart % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }
        return switch (mainPart % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }
}
