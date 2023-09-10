import static java.lang.Math.*;

import java.util.Locale;

public class Format {
    String formatCurrency(double amount) {
        String currency = "";
        int num = (int) floor(amount);
        if (num == 1) {
            num = 1;
        } else if (1 < num & num < 4) {
            num = 2;
        } else if ((5 < num & num < 9) | (10 < num & num < 20)) {
            num = 3;
        }
        switch (num) {
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
