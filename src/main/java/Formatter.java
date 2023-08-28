public class Formatter {

    public String format(double money) {
        String rub = "";
        int roundMoney = (int) money;
        if (roundMoney == 0) {
            rub = "рублей";
        } else if (roundMoney == 1) {
            rub = "рубль";
        } else {
            if(roundMoney % 10 < 5  && !(roundMoney % 100 > 10 && roundMoney % 100 < 20)) {
                rub = "рубля";
            } else {
                rub = "рублей";
            }
        }
        return String.format("%.2f %s", money, rub);
    }
}