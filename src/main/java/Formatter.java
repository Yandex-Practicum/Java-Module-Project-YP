import java.lang.constant.Constable;

public class Formatter {

    public String format (double fullSum) {
        int shortSum = (int) fullSum;
        String keyWord = new String();

        int penultimateDigit = shortSum % 100 / 10;

        if (penultimateDigit == 1) {
            keyWord = "рублей";
        }

        switch (shortSum % 10) {
            case 1:
                keyWord = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                keyWord = "рубля";
                break;
            default:
                keyWord = "рублей";
                break;
        }

        return keyWord;

    }
}
