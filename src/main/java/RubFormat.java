public class RubFormat {
    public String rubFormat(double rub) {

        String formattedRub = String.format("%.2f", rub) + " руб.";

        int rubles = (int) rub;
        if (rubles % 10 == 1 && rubles % 100 != 11) {
            formattedRub = formattedRub.replace(" руб.", " рубль");
        } else if ((rubles % 10 == 2 || rubles % 10 == 3 || rubles % 10 == 4) && (rubles % 100 != 12 && rubles % 100 != 13 && rubles % 100 != 14)) {
            formattedRub = formattedRub.replace(" руб.", " рубля");
        } else {
            formattedRub = formattedRub.replace(" руб.", " рублей");
        }
        return formattedRub;
    }
}

