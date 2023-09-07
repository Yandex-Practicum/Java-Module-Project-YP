import static java.lang.Math.*;

import java.util.Locale;

public class Format {
    String formatCurrency(double amount) {
        String currency = "";
        switch ((int) floor(amount)) {
            case 1:
                currency = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                currency = "рубля";
                break;
            default:
                currency = "рублей";
                break;
        }
        return currency;
    }

    void getResult(double totalAmount, double personalAmount) {
        String format = "Итоговая сумма: %.2f " + formatCurrency(totalAmount) + ".\nКаждый должен заплатить: %.2f " + formatCurrency(personalAmount);
        String result = String.format(Locale.US, format, totalAmount, personalAmount);
        System.out.println(result);
    }
}
