public class Formatter {

    public String padejRub(double sum) {
        int num = (int) Math.floor(sum);
        if (num == 1) {
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
