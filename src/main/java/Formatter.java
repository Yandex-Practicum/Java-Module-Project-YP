public class Formatter {
    public String GetRubleAddition(int num) {
        var preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        switch (num % 10) {
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
