import static java.lang.Math.*;

import java.util.Locale;

public class Format {
    String formatCurrency(double amount) {
        String currency = "";
        int n = (int) floor(amount);
        if (n == 1) {
            n = 1;
        } else if (1 < n & n < 4) {
            n = 2;
        } else if ((5 < n & n < 9) | (10 < n & n < 20)) {
            n = 3;
        }
        switch (n) {
            case 1:
                currency = "рубль";
                break;
            case 2:
                currency = "рубля";
                break;
            default:
                currency = "рублей";
                break;
        }
        return currency;
    }

    void printResult(double totalAmount, double personalAmount) {
        String format = "Итоговая сумма: %.2f " + formatCurrency(totalAmount) + ".\nКаждый должен заплатить: %.2f " + formatCurrency(personalAmount);
        String result = String.format(Locale.US, format, totalAmount, personalAmount);
        System.out.println(result);
    }
}
