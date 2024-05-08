public class Padesh {
    float rubles;
    public static String padesh(float rubles){ //метод для рассчёта правильного падежа
        String finalRubles;
        int ost = (int)rubles;
        ost %= 10;
        if (((int)rubles)%100>10 && ((int)rubles)%100<15) {
            return finalRubles = "рублей";
        }else if(ost==1){
            finalRubles = "рубль";
            return finalRubles;
        } else if (ost>1 && ost<5){
            finalRubles = "рубля";
            return finalRubles;
        }else{
            finalRubles = "рублей";
            return finalRubles;
        }
    }
}
