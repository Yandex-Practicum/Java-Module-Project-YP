import java.util.Scanner;
public class Declensions {
        public static String declensions(double rub) {
            switch (declensions) {
                case  (rub % 100 >= 11 && rub%100 <= 14):
                    return "ей";
                break;
                case (rub % 10 == 1):
                    return "ь";
                break;
                case (rub % 10 == 2 || rub % 10 == 3 || rub % 10 == 4):
                    return "я";
                break;
                default:
                    return "ей";
                break;
            }

        }

    }

