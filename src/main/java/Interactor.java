import java.util.ArrayList;
import java.util.List;

public class Interactor {
    private static final String TERMINATE_PHRASE = "завершить";

    public static int acquireAmountOfPeople() {
        System.out.println("<На сколько человек разделить счет?>");
        int amountOfPeople = Utils.getIntFromTerminal();
        while(amountOfPeople <= 1) {
            if (amountOfPeople == 1) {
                System.out.println("<Нет смысла делить счет на самого себя.>");
            } else {
                System.out.println("<Количество человек должно быть более 1.>");
            }
            amountOfPeople = Utils.getIntFromTerminal();
        }
        return amountOfPeople;
    }

    private static double getPriceFromTerminal() {
        double price = Utils.getDoubleFromTerminal();
        while(price <= 0.0) {
            System.out.println("<Цена должна быть больше 0.>");
            price = Utils.getDoubleFromTerminal();
        }
        return price;
    }

    private static Item getItemFromTerminal() {
        System.out.println("<Введите название позиции:>");
        String title = Utils.getStringFromTerminal(false);
        System.out.println("<Введите цену позиции:>");
        double price = getPriceFromTerminal();
        return new Item(price, title);
    }

    public static List<Item> acquireItems() {
        List<Item> items = new ArrayList<>();
        System.out.println(
                "<Введите \"Завершить\" для подведения итогов. Введите любое значение чтобы добавить новую позицию>"
        );
        String userInput = Utils.getStringFromTerminal(true);
        while(!userInput.equalsIgnoreCase(TERMINATE_PHRASE)) {
            Item item = getItemFromTerminal();
            items.add(item);
            System.out.println("<Позиция успешно добавлена.>");
            System.out.println(
                    "<Введите \"Завершить\" для подведения итогов. Введите любое значение чтобы добавить новую позицию>"
            );
            userInput = Utils.getStringFromTerminal(false);
        }
        return items;
    }
}
