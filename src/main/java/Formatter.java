class Formatter {
    public static String wordCaseCurrency(float amount) {
        String wordCurrency;
        long integralPart = (long) amount;
        double fractionalPart = amount - integralPart;

        if (fractionalPart > 0) {
            wordCurrency = " рублей";
        } else {
            if (integralPart % 10 == 1 && integralPart % 100 != 11) {
                wordCurrency = " рубль";
            } else if (integralPart % 10 >= 2 && integralPart % 10 <= 4
                && (integralPart % 100 < 10 || integralPart % 100 >= 20)) {
                wordCurrency = " рубля";
            } else {
                wordCurrency = " рублей";
            }
        }

        return String.format("%.2f" + wordCurrency, amount);
    }
}
