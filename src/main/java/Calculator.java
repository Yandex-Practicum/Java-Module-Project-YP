public class Calculator {
    public String divideCostByPersons(int personCount, double total) {
        double result = total / personCount;
        return formatRubles(result);
    }

    public String formatRubles(double sum) {
        int rubles = (int) sum;
        String result;
        int remainder = rubles % 10;

        if (remainder == 1 && rubles != 11) {
            result = "рубль";
        } else if (remainder >= 2 && remainder <= 4 && (rubles < 10 || rubles > 20)) {
            result = "рубля";
        } else {
            result = "рублей";
        }

        return rubles + " " + result;
    }
}
