public class Formatter {
    String format(double input) {
        String rub;
        int ending = (int)input % 100;
        if(ending>10 && ending<20){
            rub=" рублей";
        }
        else {
            switch (ending % 10) {
                case 1: {
                    rub = " рубль";
                    break;
                }
                case 2:
                case 3:
                case 4: {
                    rub = " рубля";
                    break;
                }
                default: {
                    rub = " рублей";
                    break;
                }
            }
        }
        return rub;
    }
}