import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Item> items = new ArrayList<>();

    public String showAllItems() {
        Formatter formatter = new Formatter();
        StringBuilder sb = new StringBuilder();
        sb.append("Добавленные товары: \n");

        for (Item item : items) {
            sb.append(item.name).append(" ").append(formatter.formatAmount(item.price)).append("\n");
        }
        return sb.toString();
    }

    public double calculateAmountPerPerson(int guestAmount) {
        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.price;
        }
        return totalAmount / guestAmount;
    }
}
