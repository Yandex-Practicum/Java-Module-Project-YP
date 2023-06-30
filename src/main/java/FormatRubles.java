public class FormatRubles {
    String Rubles(float sum) {
        int sum1 = (int) Math.floor(sum);

        if (sum1 > 100)
            sum1 %= 100;

        if (sum1 > 20)
            sum1 %= 10;

        switch (sum1) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
