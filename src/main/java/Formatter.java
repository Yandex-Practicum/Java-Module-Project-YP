public class Formatter {
    String toFormat(float sumForPerson) {
        String formatRubles;
        switch ((int) (Math.floor(sumForPerson)%10)) {
            case 1:
                formatRubles = " рубль";
                break;
            case 2, 3, 4:
                formatRubles = " рубля";
                break;
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
