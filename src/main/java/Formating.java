import java.util.Iterator;

public class Formating {

    static String sumForMan = String.format("%.2f", Calculator.sumForOne);
    static int roundedSumForOne = (int) Math.floor(Calculator.sumForOne);

    public static String getNormalRubles() {

        if (roundedSumForOne % 100 > 4 && roundedSumForOne % 100 < 21) {
            return "рублей";
        } else if (roundedSumForOne % 10 == 1) {
            return "рубль";
        } else if ((roundedSumForOne % 10) > 1 && (roundedSumForOne % 10) < 5) {
            return "рубля";
        }
        return "рублей";
    }
}