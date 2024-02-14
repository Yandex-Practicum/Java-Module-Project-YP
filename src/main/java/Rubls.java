public class Rubls { // Я только меняю окончание у слова рубль и больше ничего!

    public String Rus(double countCheck){ // на входе получаем параметр - сумма чека
        int value = (int) countCheck;
        String flag = "";
        if (value >=11 & value<20) {
            flag = "рублей";
        }else {
            switch ((value % 10)) {
                case 1:
                    flag = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    flag = "рубля";
                    break;
                default:
                    flag = "рублей";
                    break;
            }
        }
        return flag;
    }
}