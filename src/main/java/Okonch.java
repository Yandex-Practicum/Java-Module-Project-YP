public class Okonch {
    public static String getAddition(double prPrice) {
        int prValue = (int) Math.floor(prPrice);
        int preLastDigit = prValue % 100 / 10;

        if (preLastDigit == 1) {
            return " рублей";
        }

        switch (prValue % 10) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }
}
