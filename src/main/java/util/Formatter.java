package util;

public class Formatter {

    // Метод вычисляет правильный падеж в зависимости от целочисленной части входящего double
    public static String formatAmount(double amount) {
        String currency = "рубль";
        int rubles = (int) amount;
        if (rubles == 0 || rubles >= 5 && rubles <= 20 || rubles % 10 >= 5 || rubles % 10 == 0) {
            currency = "рублей";
        } else if (rubles % 10 == 1) {
            currency = "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4) {
            currency = "рубля";
        }
        return String.format("%.2f %s", amount, currency);
    }
}
