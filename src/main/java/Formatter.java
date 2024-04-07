public class Formatter {
    public static String padezh;
    public String formatRub(int result2) {
        int x = result2 % 10;
        int y = result2 % 100;
        if(x == 0 || (x >= 5 && x <= 9) || (y>= 11 && y <= 14)){
            padezh = "рублей";
        }else if (x == 1 ) {
            padezh = "рубль";
        }else {
            padezh = "рубля";
        }
        return padezh;
    }
}