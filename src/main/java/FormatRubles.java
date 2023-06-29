public class FormatRubles {
    String Rubles (float sum) {
        int sum1 = (int) Math.floor(sum);

        String rub1 = "рубль";
        String rub2 = "рубля";
        String rub3 = "рублей";

        if (sum1 > 100)
            sum1 %= 100;

        if (sum1 > 20)
            sum1 %= 10;

        switch (sum1) {
            case 1:
                return rub1;
            case 2:
            case 3:
            case 4:
                return rub2;
            default:
                return rub3;
        }
    }
}
