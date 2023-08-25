import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int partnersCount;
        Dialog dial = new Dialog();
        ArrayList<Goods> bill = new ArrayList<>();// позиции в счете - динамика

        dial.greetings();
        partnersCount = dial.getCount();
        dial.getGoods(bill);
        dial.showList(bill);
        dial.showHowMuchToPay(partnersCount, bill);
        dial.sayBye();
    }
}