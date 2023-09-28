public class Formatter {

    public String format(double money) {
        String rub = "";
        int roundMoney = (int) money;
        if (roundMoney % 10 == 0) {
            rub = "рублей";
        } else if (roundMoney % 10 == 1 && !(roundMoney % 100 >= 11 && roundMoney % 100 <= 19)) {
            rub = "рубль";
        } else {
            if(roundMoney % 10 < 5  && !(roundMoney % 100 >= 11 && roundMoney % 100 <= 19)){
                rub = "рубля";
            } else {
                rub = "рублей";
            }
        }
        return String.format("%.2f %s", money, rub);
    }
}