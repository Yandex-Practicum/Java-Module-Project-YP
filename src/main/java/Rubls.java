public class Rubls { // Я только меняю окончание у слова рубль и больше ничего!

    public String Rus(double countCheck){
        int rubles = (int) countCheck;
        int lastTwoDigits = rubles % 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return " рублей";
        } else {
            int lastDigit = rubles % 10;
            switch (lastDigit) {
                case 1 : return " рубль";
                case 2 :
                case 3 :
                case 4 :  return " рубля";
                default : return " рублей";
            }
        }
    }
}