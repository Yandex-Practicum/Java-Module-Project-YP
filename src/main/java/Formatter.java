public class Formatter {
    public static void main(String[] args) {
    }
    public static String GetDeclinationRub(int num) {
        var penultimateDigit = num % 100 / 10;
        if (penultimateDigit == 1)
        {
            return "рублей.";
        }

        switch (num % 10)
        {
            case 1:
                return "рубль.";
            case 2:
            case 3:
            case 4:
                return "рубля.";
            default:
                return "рублей.";
        }
    }
}
