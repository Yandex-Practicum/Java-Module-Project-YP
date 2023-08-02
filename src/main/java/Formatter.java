public class Formatter {
    static String toFormat(float sumForPerson) {
        String formatRubles;
        switch ((int) (Math.floor(sumForPerson)%10)) {
            case 1: {
                if ((int) (Math.floor(sumForPerson)%100) == 11) formatRubles = " рублей";
                else formatRubles = " рубль";
                break;
            }
            case 2, 3, 4: {
                if ((int) (Math.floor(sumForPerson)%100) == 12 ||
                        (int) (Math.floor(sumForPerson)%100) == 13 ||
                        (int) (Math.floor(sumForPerson)%100) == 14) formatRubles = " рублей";
                else formatRubles = " рубля";
                break;
            }
            case 5, 6, 7, 8, 9, 0:
                formatRubles = " рублей";
                break;
            default:
                formatRubles = " руб.";
                break;
        }
            return formatRubles;
    }
}
