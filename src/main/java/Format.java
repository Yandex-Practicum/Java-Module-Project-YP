import java.util.ArrayList;

public class Format {
    ReadLine sizePeople = new ReadLine();
    Calculator calculator = new Calculator();

    Menu menu = new Menu();
    public void endingPeople() {
        for (int i = 0; i == menu.quantityPeople; i++){
            if (i >= 2 && i <= 4) {
                System.out.println("человека");
            } else {
                System.out.println("человек");
            }
        }
    }


    public double sumPriceMenu() {
        return menu.sumPriceMenu() / menu.quantityPeople;
    }

    public void endingMoney() {

        for (int i = 0; i == 2; i++) {

        }
    }
}
