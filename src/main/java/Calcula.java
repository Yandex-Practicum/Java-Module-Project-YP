public class Calcula {
    public String doubleToRuble (double price_){ // именует рубли
        String str;
        double intOfPrice=Math.floor(price_);
        if (intOfPrice>100){// для аналитики "надцать"
            intOfPrice=intOfPrice%100;
        }
        if (intOfPrice==11 || intOfPrice==12|| intOfPrice==13|| intOfPrice==14) {
            return  "рублей";
        }
        switch ((int)intOfPrice %10) {// для аналитики последней цифры
            case 1:
                str = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                str = "рубля";
                break;
            default:
                str = "рублей";
        }
        return str;
    }
    public String intToGoodies (int count){ // именует вкусняшки
        String str;
        if (count>100){// для аналитики "надцать"
            count=count%100;
        }
        if (count>10 && count<20) {
            return  "вкусняшек";
        }
        switch ((int)count %10) {// для аналитики последней цифры
            case 1:
                str = "вкусняшка";
                break;
            case 2:
            case 3:
            case 4:
                str = "вкусняшки";
                break;
            default:
                str = "вкусняшек";
        }
        return str;
    }
}
