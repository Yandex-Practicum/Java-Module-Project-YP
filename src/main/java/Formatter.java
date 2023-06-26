public class Formatter {
    final private static String[] strRub = {
            " рубль",
            " рубля",
            " рублей"
    };

    public static String getEndWord(double productPrice) {
        int intPrice = (int) productPrice;

        if (intPrice >= 5 && intPrice <= 19) {
            return strRub[2];
        } else {
            switch (intPrice % 10) {
                case 2:
                case 3:
                case 4:
                    return strRub[1];
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return strRub[2];
            }
        }
        return strRub[0];
    }
}
