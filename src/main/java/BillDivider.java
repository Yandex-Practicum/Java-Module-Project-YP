import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BillDivider {
    private final String INT_REGEX = "\\b(?<!\\.)\\d+(?!\\.)\\b";
    private final String DOUBLE_REGEX = "\\d*\\.\\d{2}";
    private int userCount;
    private List<Item> itemList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    PluralHelper pluralRubles = new PluralHelper("Рублю", "Рубля", "Рублей");
    PluralHelper pluralGuests = new PluralHelper("гость", "гостя", "гостей");
    public void createAndSplitBill() {
        getUserCount();
        requestItems();
        intermediateResult();
        splitBill();
    }
    private void getUserCount() {
        this.userCount = readIntUntilValid("Введите кол-во человек: ");
    }
    private int readIntUntilValid(String requestMessage) {
        System.out.print(requestMessage);
        String value = scanner.nextLine();
        boolean isValidValue = value.matches(INT_REGEX) && Integer.parseInt(value) > 1;

        while (!isValidValue) {
            System.out.println("Ошибка, введено неверное значение, попробуйте снова...");
            System.out.print(requestMessage);

            value = scanner.nextLine();
            isValidValue = value.matches(INT_REGEX) && Integer.parseInt(value) > 1;
        }

        return Integer.parseInt(value);
    }
    private void requestItems() {
        String input = "";
        while (!input.equalsIgnoreCase("Завершить")) {
            addItem(requestItem());
            System.out.println("Желаете добавить еще один товар?\nВведите \"Завершить\", если хотите закончить добавление.");
            input = scanner.nextLine();
        }
    }
    private void addItem(Item newItem) {
        itemList.add(newItem);

        String newItemName = newItem.getName();
        String line = "~".repeat(47 + newItemName.length());

        System.out.println(line);
        System.out.printf("Товар \"%s\", стоимостью %s успешно добавлен!%n", newItemName, pluralRubles.getFormattedPluralPattern(newItem.getPrice(), "%.2f %s"));
        System.out.println(line);
    }
    private Item requestItem() {
        String name = readStringUntilValid("Введите название товара: ");
        double price = readDoubleUntilValid("Введите Стоимость (в формате рубли.копейки): ");
        return new Item(name, price);
    }
    private String readStringUntilValid(String requestMessage) {
        System.out.print(requestMessage);
        String value = scanner.nextLine();

        while (value.trim().isEmpty()) {
            System.out.println("Ошибка, введено неверное значение, попробуйте снова...");
            System.out.print(requestMessage);
            value = scanner.nextLine();
        }

        return value;
    }
    private double readDoubleUntilValid(String requestMessage) {
        System.out.print(requestMessage);
        String value = scanner.nextLine();

        while (!value.matches(DOUBLE_REGEX)) {
            System.out.println("Ошибка, введено неверное значение, попробуйте снова...");
            System.out.print(requestMessage);
            value = scanner.nextLine();
        }

        return Double.parseDouble(value);
    }
    private void intermediateResult() {
        int tabSpace = Math.max(15, Collections.max(itemList.stream().map(Item::getName).toList(), Comparator.comparing(String::length)).length());
        String lineCurve = "~".repeat(tabSpace * 2 + 7);
        String linePlain = "-".repeat(tabSpace * 2 + 7);

        System.out.println(lineCurve);
        System.out.println(pluralGuests.getFormattedPluralPattern(userCount, "Общий чек на %.0f %s"));
        System.out.println(lineCurve);
        System.out.println("Добавленные товары:");
        System.out.println(lineCurve);
        System.out.printf("| %-" + tabSpace + "s | %-" + tabSpace + "s |%n", "Название товара", "Стоимость");
        System.out.println(linePlain);
        for (Item item : itemList) {
            System.out.printf("| %-" + tabSpace + "s | %-" + tabSpace + "s |%n", item.getName(), pluralRubles.getFormattedPluralPattern(item.getPrice(), "%.2f %s"));
        }
        System.out.println(linePlain);
    }
    private void splitBill() {
        double perGuest = itemList.stream().map(Item::getPrice).reduce(0.0, Double::sum) / userCount;
        System.out.println(pluralRubles.getFormattedPluralPattern(perGuest, "Каждый должен заплатить по %.2f %s"));
    }
}