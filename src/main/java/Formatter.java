

public class Formatter {
    static String a = "";
    static void FormatterRubles() {
    int floor = (int) Math.floor(Main.sumMain);
        if (floor % 100 >= 11 && floor % 100 <= 14) {
        a = "рублей";
    } else if (floor % 10 == 1) {
        a = "рубль";
    } else if (floor % 10 >= 2 && floor % 10 <= 4) {
        a = "рубля";
    } else if (floor % 10 >= 5 && floor % 10 <= 8) {
        a = "рублей";
    }else if (floor % 9 == 0) {
        a = "рублей";
    } else if (floor % 10 == 0) {
        a = "рублей";
}}}
