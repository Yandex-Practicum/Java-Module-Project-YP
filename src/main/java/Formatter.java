public class Formatter {
    public static String formatRuble(double value) {
        String[] endings = {"рубль", "рубля", "рублей"};
        int index = (int)Math.floor(value) % 100;
        if (index > 10 && index < 20) return endings[2];
        index = index % 10;
        if (index == 1) return endings[0];
        if (index > 1 && index < 5) return endings[1];
        return endings[2];
    }

}
