public class Calcula {
    public String doubleToRuble (double price_){ // именует рубли
        String str;
        double d=Math.floor(price_);
        if (d==11 || d==12|| d==13|| d==14) {
            return  "рублей";
        }
        switch ((int)d %10) {
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
}
