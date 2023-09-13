import static java.lang.Math.*;

import java.util.Locale;

public class Format {
    String formatCurrency(double amount) {
        int num = (int) floor(amount);
        if (num > 100)
            num %= 100;
        if (num > 20)
            num %= 10;

        switch (num) {
            case 1:
                return "рубль";
            case 2, 3, 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    void printResult(double totalAmount, double personalAmount) {
        String format = "Итоговая сумма: %.2f " + formatCurrency(totalAmount) + ".\nКаждый должен заплатить: %.2f " + formatCurrency(personalAmount);
        String result = String.format(Locale.US, format, totalAmount, personalAmount);
        System.out.println(result);
    }
}
