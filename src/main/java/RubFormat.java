public class RubFormat {
    String format(double input) {
        String rub;


        int ending = (int)(Math.floor(input)) % 10;
         switch (ending) {
            case 1: {
                rub = " рубль";
                break;
            }
            case 2:
            case 3:
            case 4:
            {rub = " рубля"; //// как сделать 114 рублей? не могу понять
                break;}
            default : {
                rub = " рублей";
                break;
            }
        }
        return rub;
    }
}




