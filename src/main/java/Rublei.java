
public class Rublei
{
    public static int rubl;
    public static String rublei(float itogoSKazhdogo)
    {
        String rublei = "";
        rubl= (int) itogoSKazhdogo;
        if (rubl>=11 && rubl<=14)  rublei="ей";
        else if (rubl%10==1) rublei="ь";
        else if ((rubl%10== 2 || rubl%10== 3 || rubl%10== 4)) rublei="я";
        else rublei="ей";
        return rublei;
    }

}
