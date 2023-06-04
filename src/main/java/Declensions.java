public class Declensions{
    public String declensions(double rub){
        if (rub % 100 >= 11){
            return "ей";
        } else if (rub % 10 == 1) {
            return "ь";
        } else if (rub % 10 == 4) {
            return "я";
        } else if (rub % 100 <= 14) {
            return "ей";
        } else if (rub % 10 == 2) {
            return "я";
        } else if (rub % 10 == 3) {
            return "ей";
        }else {
            return "ей";
        }
    }
}