public class Formatter {
    public static String calc(double result) {
        String rubleForm;
        int sum = (int) Math.floor(result) % 100;
        if (sum >= 11 && sum <= 14) {
            rubleForm = "рублей";
        } else {
            sum %= 10;
            if (sum == 1) {
                rubleForm = "рубль";
            }
            else if (sum>1 && sum<5) {
                rubleForm = "рубля";
            }
            else {
                rubleForm = "рублей";
            }
        }
        return rubleForm;
    }
}
