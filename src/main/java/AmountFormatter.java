public class AmountFormatter {
    public static String formatAmount(double amount) {
        //РАЗДЕЛЯЕМ ЦЕЛУЮ ЧАСТЬ И ДРОБНУЮ
        int rubles = (int) amount;
        int kopecks = (int) ((amount - rubles) * 100);

        //ВЫЗОВ ФОРМАТТЕРА С ШАБЛОНОМ (в зависимости от рубля/копейки)
        String rublesText = formatInt(rubles, "рубль", "рубля", "рублей");
        String kopecksText = formatInt(kopecks, "копейка", "копейки", "копеек");
        return " " + rublesText + " " + kopecksText;
    }

    private static String formatInt(int amount, String one, String twoFour, String other) {
        //УЗНАЁМ ПОСЛЕДНЮЮ И ПРЕДПОСЛЕДНЮЮ ЦИФРУ В ЧИСЛЕ
        int mod10 = amount % 10;
        int mod100 = amount % 100;

        //ИЩЕМ ПОДХОДЯЩИЙ СЦЕНАРИЙ
        if (mod10 == 1 && mod100 != 11) {
            return amount + " " + one;
        } else if ((mod10 >= 2 && mod10 <= 4) && !(mod100 >= 12 && mod100 <= 14)) {
            return amount + " " + twoFour;
        } else {
            return amount + " " + other;
        }
    }
}